package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DoctorSpecialtyReponse(String message, LocalDateTime createdAt) {
}
