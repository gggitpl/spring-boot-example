package com.gggitpl.upload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileResponse {

  private String filename;
  private String fileUri;
  private String fileDownloadUri;
  private String fileType;
  private Long fileSize;

}
