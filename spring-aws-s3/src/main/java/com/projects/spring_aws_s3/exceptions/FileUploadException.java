package com.projects.spring_aws_s3.exceptions;

public class FileUploadException extends SpringBootFileUploadException {

    public FileUploadException(String message) {
        super(message);
    }
}
