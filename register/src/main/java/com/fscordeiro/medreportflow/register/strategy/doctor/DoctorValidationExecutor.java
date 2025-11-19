package com.fscordeiro.medreportflow.register.strategy.doctor;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DoctorValidationExecutor {

    private final List<DoctorValidation> validations;

    public void execute(DoctorRegisterRequest request) {
        validations.forEach(v -> v.validate(request));
    }
}