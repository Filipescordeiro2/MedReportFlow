package com.fscordeiro.medreportflow.register.service;

import com.fscordeiro.medreportflow.register.dto.request.SpecialtyRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyResponse;

import java.util.UUID;

public interface SpecialtyService {
    public SpecialtyRegisterResponse createSpecialty(SpecialtyRegisterRequest specialtyRegisterRequest);
    public SpecialtyResponse getSpecialty(UUID specialtyId);
}
