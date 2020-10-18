package com.groupal.libreriaPrismaBackend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
