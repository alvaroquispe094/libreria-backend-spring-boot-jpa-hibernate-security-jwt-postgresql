package com.groupal.libreriaPrismaBackend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class SQLException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SQLException(String message) {
        super(message);
    }

    public SQLException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
