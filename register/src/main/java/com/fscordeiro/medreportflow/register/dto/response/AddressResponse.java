package com.fscordeiro.medreportflow.register.dto.response;

import lombok.Builder;

@Builder
public record AddressResponse(String address,
                              String city,
                              String state,
                              String zip,
                              String country) {
}
