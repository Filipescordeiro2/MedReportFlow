package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ClinicRegisterRequest(@NotBlank(message = "cnpj is required")
                                    String cnpj,
                                    @NotBlank(message = "name is required")
                                    String name,
                                    @NotBlank(message = "description is required")
                                    String description,
                                    @NotBlank(message = "phone is required")
                                    String phone,
                                    @NotBlank(message = "email is required")
                                    String email,
                                    @Valid
                                    @NotNull(message = "addressClinic is required")
                                    AddressRequest addressClinic) {
}
