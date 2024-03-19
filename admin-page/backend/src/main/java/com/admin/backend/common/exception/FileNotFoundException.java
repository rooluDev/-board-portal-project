package com.admin.backend.common.exception;

/**
 * 파일이 없을 때 발생하는 Exception
 */
public class FileNotFoundException extends RuntimeException{
    public FileNotFoundException(String message) {
        super(message);
    }
}
