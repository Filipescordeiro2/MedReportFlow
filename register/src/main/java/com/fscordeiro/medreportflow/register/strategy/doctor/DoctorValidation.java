package com.fscordeiro.medreportflow.register.strategy.doctor;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;

public interface DoctorValidation {
    void validate(DoctorRegisterRequest request);
}
