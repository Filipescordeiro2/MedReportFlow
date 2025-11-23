package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ClinicDoctorResponse(String message, LocalDateTime createAt) {
}
