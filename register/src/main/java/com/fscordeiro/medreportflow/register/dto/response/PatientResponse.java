package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record PatientResponse(String name,
                              String cpf,
                              String surname,
                              String gender,
                              LocalDate birthDate,
                              Integer age,
                              String phone,
                              String email,
                              Boolean active,
                              LocalDateTime createdAt,
                              LocalDateTime updatedAt,
                              AddressResponse address) {
}
