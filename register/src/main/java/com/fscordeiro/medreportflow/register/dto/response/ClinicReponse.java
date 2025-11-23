package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

@Builder
public record ClinicReponse(String cnpj,
                            String name,
                            String description,
                            String phone,
                            String email,
                            AddressResponse addressClinic) {
}
