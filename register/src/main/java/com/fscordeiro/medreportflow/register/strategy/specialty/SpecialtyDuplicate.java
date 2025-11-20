package com.fscordeiro.medreportflow.register.strategy.specialty;

import com.fscordeiro.medreportflow.register.dto.request.SpecialtyRegisterRequest;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpecialtyDuplicate implements SpecialtyValidation {

    private final SpecialtyRepository specialtyRepository;

    @Override
    public void validate(SpecialtyRegisterRequest request) {
        specialtyRepository.findBySpecialty(request.specialty()).ifPresent(specialty -> {
            throw new BusinessException("There is already a Specialty registration");
        });
    }
}
