package com.fscordeiro.medreportflow.register.strategy.specialty;

import com.fscordeiro.medreportflow.register.dto.request.SpecialtyRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SpecialtyValidationExecutor {

    private final List<SpecialtyValidation> validations;

    public void execute(SpecialtyRegisterRequest request) {
        validations.forEach(v -> v.validate(request));
    }
}
