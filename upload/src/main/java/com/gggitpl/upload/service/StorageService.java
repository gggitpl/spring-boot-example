package com.gggitpl.upload.service;

import com.gggitpl.upload.model.StorageFile;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {


    StorageFile store(final MultipartFile file);

    Resource load(final String filename);

    String addHost(final String path);
}
