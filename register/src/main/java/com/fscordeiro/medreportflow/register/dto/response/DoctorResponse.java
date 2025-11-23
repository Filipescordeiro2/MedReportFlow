package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record DoctorResponse(String cpf,
                             String name,
                             String email,
                             String phone,
                             String gender,
                             LocalDate birthDate,
                             Integer age,
                             RegulatoryResponse regulatory,
                             LocalDateTime createdAt,
                             LocalDateTime updatedAt,
                             Boolean active) {
}
