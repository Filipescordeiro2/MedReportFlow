package com.fscordeiro.medreportflow.register.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record DoctorRegisterRequest(String cpf, String name, String email, String phone, String typeRegulatory, Integer numberRegulatory, String gender,
                                    LocalDate birthDate,String specialty) {
}
