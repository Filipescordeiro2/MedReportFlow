package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddressRequest(@NotBlank(message = "address is required")
                             String address,
                             @NotBlank(message = "city is required")
                             String city,
                             @NotBlank(message = "state is required")
                             String state,
                             @NotBlank(message = "zip is required")
                             String zip,
                             @NotBlank(message = "country is required")
                             String country) {
}
