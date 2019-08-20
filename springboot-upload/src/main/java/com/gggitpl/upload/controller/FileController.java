package com.gggitpl.upload.controller;

import static java.util.stream.Collectors.toList;

import com.gggitpl.upload.model.UploadFileResponse;
import com.gggitpl.upload.service.FileStorageService;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping("/upload")
public class FileController {

  @Autowired
  private FileStorageService fileStorageService;

  @PostMapping
  public UploadFileResponse upload(@RequestParam("file") MultipartFile file) {
    String fileName = fileStorageService.storeFile(file);
    String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/upload/")
        .path(fileName)
        .toUriString();
    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/upload/download/")
        .path(fileName)
        .toUriString();
    return UploadFileResponse.builder()
        .filename(fileName)
        .fileUri(fileUri)
        .fileDownloadUri(fileDownloadUri)
        .fileType(file.getContentType())
        .fileSize(file.getSize())
        .build();
  }

  @PostMapping("/multiple")
  public List<UploadFileResponse> uploads(@RequestParam("files") MultipartFile[] files) {
    return Arrays.stream(files)
        .map(this::upload)
        .collect(toList());
  }

  @GetMapping("/{fileName:.+}")
  public ResponseEntity<Resource> look(@PathVariable String fileName, HttpServletRequest request) {
    Resource resource = fileStorageService.loadFileAsResource(fileName);
    return ResponseEntity.ok()
        .cacheControl(CacheControl.maxAge(12, TimeUnit.HOURS).cachePublic())
        .eTag(String.valueOf(System.currentTimeMillis()))
        .contentType(MediaType.parseMediaType(getContentType(request, resource)))
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "inline;filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }

  @GetMapping("/download/{fileName:.+}")
  public ResponseEntity<Resource> download(@PathVariable String fileName,
      HttpServletRequest request) {
    Resource resource = fileStorageService.loadFileAsResource(fileName);
    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(getContentType(request, resource)))
        .header(
            HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + resource.getFilename() + "\"")
        .body(resource);
  }

  private String getContentType(final HttpServletRequest request, final Resource resource) {
    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException e) {
      log.debug("Could not determine file type.");
    }
    if (StringUtils.isEmpty(contentType)) {
      contentType = "application/octet-stream";
    }
    return contentType;
  }

}
