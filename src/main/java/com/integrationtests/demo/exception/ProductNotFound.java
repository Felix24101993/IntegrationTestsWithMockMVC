package com.integrationtests.demo.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFound extends NestedRuntimeException {
    public ProductNotFound(String msg) {
        super(msg);
    }
}
