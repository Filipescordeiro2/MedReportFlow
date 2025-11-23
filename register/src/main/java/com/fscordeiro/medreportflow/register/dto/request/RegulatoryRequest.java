package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record RegulatoryRequest(@NotBlank(message = "state is required")
                                String state,
                                @NotBlank(message = "typeRegulatory is required")
                                String typeRegulatory,
                                @NotNull(message = "numberRegulatory is required")
                                String numberRegulatory) {
}
