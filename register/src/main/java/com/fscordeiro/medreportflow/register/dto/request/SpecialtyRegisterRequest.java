package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record SpecialtyRegisterRequest(
        @NotBlank(message = "specialty is required")
        String specialty,
        @NotBlank(message = "description is required")
        String description) {
}
