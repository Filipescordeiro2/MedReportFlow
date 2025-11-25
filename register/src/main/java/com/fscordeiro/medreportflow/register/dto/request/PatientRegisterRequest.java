package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record PatientRegisterRequest(@NotBlank(message = "name is required")
                                     String name,
                                     @NotBlank(message = "cpf is required")
                                     String cpf,
                                     @NotBlank(message = "surname is required")
                                     String surname,
                                     @NotBlank(message = "gender is required")
                                     String gender,
                                     @NotNull(message = "birthDate is required")
                                     LocalDate birthDate,
                                     @NotBlank(message = "name is required")
                                     String phone,
                                     @NotBlank(message = "name is required")
                                     String email,
                                     @NotBlank(message = "name is required")
                                     String password,
                                     @Valid
                                     @NotNull(message = "address is required")
                                     AddressRequest address) {
}
