package com.gggitpl.upload.service.impl;

import com.gggitpl.upload.exception.FileStorageException;
import com.gggitpl.upload.exception.FileStorageNotFoundException;
import com.gggitpl.upload.model.StorageFile;
import com.gggitpl.upload.properties.StorageProperties;
import com.gggitpl.upload.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;

@Service
public class StorageServiceImpl implements StorageService {

    private Path storageLocation;

    @Autowired
    public StorageServiceImpl(StorageProperties storageProperties) {
        this.storageLocation = Paths.get(storageProperties.getPath()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.storageLocation);
        } catch (IOException e) {
            throw new FileStorageNotFoundException("Could not create the directory where the uploaded files will be stored.", e);
        }
    }


    @Override
    public StorageFile store(MultipartFile file) {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        if (originalFilename.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + originalFilename);
        }
        String filename = Instant.now().toEpochMilli() + "." + StringUtils.getFilenameExtension(originalFilename);
        Path targetLocation = this.storageLocation.resolve(filename);
        try {
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String url = UriComponentsBuilder.fromPath("storage/").path(filename).toUriString();
            String download = UriComponentsBuilder.fromPath("storage/download/").path(filename).toUriString();
            //做数据库操作,不需要host信息
            StorageFile storageFile = StorageFile.builder()
                    .contentType(file.getContentType())
                    .size(file.getSize())
                    .url(url)
                    .name(filename)
                    .download(download)
                    .downloadName(originalFilename)
                    .build();
            //返回时添加当前host信息,返回完整访问路径
            storageFile.setUrl(this.addHost(storageFile.getUrl()));
            storageFile.setDownload(this.addHost(storageFile.getDownload()));
            return storageFile;
        } catch (IOException e) {
            throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!", e);
        }
    }

    @Override
    public Resource load(final String filename) {
        Path filePath = this.storageLocation.resolve(filename).normalize();
        try {
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileStorageNotFoundException("File not found " + filename);
            }
        } catch (MalformedURLException e) {
            throw new FileStorageNotFoundException("File not found " + filename, e);
        }
    }

    @Override
    public String addHost(String path) {
        return ServletUriComponentsBuilder.fromCurrentServletMapping().path(path).toUriString();
    }
}
