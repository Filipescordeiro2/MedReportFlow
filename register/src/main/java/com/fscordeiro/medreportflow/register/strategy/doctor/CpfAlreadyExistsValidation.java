package com.fscordeiro.medreportflow.register.strategy.doctor;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CpfAlreadyExistsValidation implements DoctorValidation {

    private final DoctorRepository doctorRepository;

    @Override
    public void validate(DoctorRegisterRequest request) {
        doctorRepository.findById(request.cpf()).ifPresent(doctor -> {
            throw new BusinessException("There is already a CPF registration for this doctor");
        });
    }
}