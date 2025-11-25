package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record LinkedSpecialtyRequest(@NotBlank(message = "linkedSpecialty.specialty is required")
                                     String specialty ) {
}
