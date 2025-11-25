package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LinkedRequest(@NotBlank(message = "linked.cnpjClinic is required")
                            String cnpjClinic) {
}
