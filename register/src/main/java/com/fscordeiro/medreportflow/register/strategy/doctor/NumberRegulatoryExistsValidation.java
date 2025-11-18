package com.fscordeiro.medreportflow.register.strategy.doctor;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberRegulatoryExistsValidation implements DoctorValidation {

    private final DoctorRepository doctorRepository;

    @Override
    public void validate(DoctorRegisterRequest request) {
        doctorRepository.findByNumberRegulatory(request.numberRegulatory()).ifPresent(doctor -> {
            throw new BusinessException("There is already a NumberRegulatory registration for this doctor");
        });
    }
}