package com.fscordeiro.medreportflow.register.strategy.specialty;

import com.fscordeiro.medreportflow.register.dto.request.SpecialtyRegisterRequest;

public interface SpecialtyValidation {
    void validate(SpecialtyRegisterRequest request);
}
