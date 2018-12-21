package com.gggitpl.upload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StorageFile {
    private String contentType;
    private Long size;
    private String url;
    private String name;
    private String download;
    private String downloadName;
}
