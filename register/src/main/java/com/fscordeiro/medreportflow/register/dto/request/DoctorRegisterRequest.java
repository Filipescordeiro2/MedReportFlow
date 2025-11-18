package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Builder
public record DoctorRegisterRequest(@CPF(message = "cpf is invalid")
                                    @NotBlank(message = "cpf is required")
                                    String cpf,
                                    @NotBlank(message = "cpf is required")
                                    String name,
                                    @Email(message = "email is invalid")
                                    @NotBlank(message = "cpf is required")
                                    String email,
                                    @NotBlank(message = "phone is required")
                                    String phone,
                                    @NotBlank(message = "typeRegulatory is required")
                                    String typeRegulatory,
                                    @NotNull(message = "numberRegulatory is required")
                                    Integer numberRegulatory,
                                    @NotNull(message = "gender is required")
                                    String gender,
                                    @NotNull(message = "birthdDate is required")
                                    LocalDate birthDate) {
}
