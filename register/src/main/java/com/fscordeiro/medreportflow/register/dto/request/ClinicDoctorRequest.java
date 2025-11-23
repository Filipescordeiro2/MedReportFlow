package com.fscordeiro.medreportflow.register.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ClinicDoctorRequest(@NotBlank(message = "cnpjClinic is required")
                                  String cnpjClinic,
                                  @NotBlank(message = "cpfDoctor is required")
                                  String cpfDoctor) {
}
