package com.projects.spring_aws_s3.exceptions;

public class FileDownloadException extends SpringBootFileUploadException {

    public FileDownloadException(String message) {
        super(message);
    }
}
