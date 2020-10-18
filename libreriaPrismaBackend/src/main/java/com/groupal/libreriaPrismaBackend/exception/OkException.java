package com.groupal.libreriaPrismaBackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class OkException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OkException(String message) {
        super(message);
    }

    public OkException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
