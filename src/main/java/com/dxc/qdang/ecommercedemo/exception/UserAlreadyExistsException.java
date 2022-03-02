package com.dxc.qdang.ecommercedemo.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

@SuppressWarnings("serial")
public class UserAlreadyExistsException
        extends AuthenticationServiceException {

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }

}
