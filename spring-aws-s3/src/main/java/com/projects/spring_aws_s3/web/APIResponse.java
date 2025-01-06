package com.projects.spring_aws_s3.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class APIResponse {
    private String message;
    private boolean isSuccessful;
    private int statusCode;
    private Object data;
}
