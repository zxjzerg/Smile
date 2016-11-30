package com.zxjdev.smile.data.Exception;

public class AuthorizationException extends RuntimeException {

    public AuthorizationException(String detailMessage) {
        super(detailMessage);
    }
}
