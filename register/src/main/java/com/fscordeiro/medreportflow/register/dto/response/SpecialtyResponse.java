package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SpecialtyResponse(String specialty, String description, LocalDateTime createdAt,LocalDateTime updatedAt,Boolean active) {
}
