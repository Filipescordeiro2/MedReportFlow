package com.fscordeiro.medreportflow.register.service;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;

public interface DoctorService {
    public DoctorRegisterResponse createDoctor(DoctorRegisterRequest request);
}
