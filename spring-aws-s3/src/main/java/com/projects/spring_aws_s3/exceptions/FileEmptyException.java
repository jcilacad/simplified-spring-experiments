package com.projects.spring_aws_s3.exceptions;

public class FileEmptyException extends SpringBootFileUploadException {

    public FileEmptyException(String message) {
        super(message);
    }
}
