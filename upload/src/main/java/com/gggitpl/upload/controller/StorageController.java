package com.gggitpl.upload.controller;

import com.gggitpl.upload.exception.FileStorageException;
import com.gggitpl.upload.model.StorageFile;
import com.gggitpl.upload.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping
    public ResponseEntity<StorageFile> store(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(storageService.store(file));
    }

    @GetMapping("{filename:.+}")
    public ResponseEntity<Resource> look(@PathVariable String filename, HttpServletRequest request) {
        try {
            Resource resource = storageService.load(filename);
            final String contentType = Optional.ofNullable(request.getServletContext().getMimeType(resource.getFile().getAbsolutePath()))
                    .orElse("application/octet-stream");
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(12, TimeUnit.HOURS).cachePublic())
                    .eTag(String.valueOf(resource.lastModified()))
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            throw new FileStorageException("Could not determine file type.");
        }
    }

    @GetMapping("download/{filename:.+}")
    public ResponseEntity<Resource> download(@PathVariable String filename, HttpServletRequest request) {
        try {
            Resource resource = storageService.load(filename);
            final String contentType = Optional.ofNullable(request.getServletContext().getMimeType(resource.getFile().getAbsolutePath()))
                    .orElse("application/octet-stream");
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException e) {
            throw new FileStorageException("Could not determine file type.");
        }
    }

}
