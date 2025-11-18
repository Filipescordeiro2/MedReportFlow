package com.fscordeiro.medreportflow.register.dto.exception;

import lombok.Builder;

import java.util.Map;

@Builder
public record ValidationErrorResponse( Map<String, String> fields) {
}
