package com.ages.doacaobackend.controller.handler.errorBody;

import java.util.List;

public class ErrorBody {

    private final List<String> errors;

    public ErrorBody(List<String> errors) {
        this.errors = errors;
    }
}
