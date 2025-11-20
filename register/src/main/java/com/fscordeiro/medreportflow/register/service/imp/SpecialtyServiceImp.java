package com.fscordeiro.medreportflow.register.service.imp;

import com.fscordeiro.medreportflow.register.dto.request.SpecialtyRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyResponse;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.mapper.SpecialtyMapper;
import com.fscordeiro.medreportflow.register.repository.SpecialtyRepository;
import com.fscordeiro.medreportflow.register.service.SpecialtyService;
import com.fscordeiro.medreportflow.register.strategy.specialty.SpecialtyValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpecialtyServiceImp implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyValidation specialtyValidation;
    private final SpecialtyMapper specialtyMapper;

    @Override
    public SpecialtyRegisterResponse createSpecialty(SpecialtyRegisterRequest specialtyRegisterRequest) {
        try {
            specialtyValidation.validate(specialtyRegisterRequest);
            specialtyRepository.save(specialtyMapper.toSpecialtyEntity(specialtyRegisterRequest));
        }catch (BusinessException | NullPointerException e) {
            throw e;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return specialtyMapper.toSpecialtyRegisterResponse();
    }

    @Override
    public SpecialtyResponse getSpecialty(UUID specialtyId) {
        return specialtyMapper.toSpecialtyResponse(specialtyRepository.findById(specialtyId)
                .orElseThrow(()-> new NotFoundException("Specialty not found")));
    }
}
