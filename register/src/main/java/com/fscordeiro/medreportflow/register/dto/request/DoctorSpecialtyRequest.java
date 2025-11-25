package com.fscordeiro.medreportflow.register.dto.request;

import lombok.Builder;

@Builder
public record DoctorSpecialtyRequest(
                                     String cpfDoctor,
                                     String specialty) {
}
