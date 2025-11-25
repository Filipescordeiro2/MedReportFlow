package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.List;

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
                                    @NotNull(message = "gender is required")
                                    String gender,
                                    @NotNull(message = "birthdDate is required")
                                    LocalDate birthDate,
                                    @Valid
                                    @NotNull(message = "regulatory is required")
                                    RegulatoryRequest regulatory,
                                    @Valid
                                    List<LinkedRequest>linked,
                                    @Valid
                                    List<LinkedSpecialtyRequest>linkedSpecialty) {
}
