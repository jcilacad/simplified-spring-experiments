package com.projects.spring_aws_s3.service;

import com.projects.spring_aws_s3.exceptions.FileDownloadException;
import com.projects.spring_aws_s3.exceptions.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String uploadFile(MultipartFile multipartFile)throws FileUploadException, IOException;

    Object downloadFile(String fileName) throws FileDownloadException, IOException;

    boolean delete(String fileName);
}
