package com.integrationtests.demo.exception;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TechnicalDetailsNotFound extends NestedRuntimeException {

    public TechnicalDetailsNotFound(String msg) { super(msg); }

}
