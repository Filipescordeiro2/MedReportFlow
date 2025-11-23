package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

@Builder
public record RegulatoryResponse(String state,
        String typeRegulatory,
        String numberRegulatory) {
}
