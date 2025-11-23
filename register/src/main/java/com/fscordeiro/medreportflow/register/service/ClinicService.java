package com.fscordeiro.medreportflow.register.service;

import com.fscordeiro.medreportflow.register.dto.request.ClinicRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicRegisterResponse;

public interface ClinicService {

    public ClinicRegisterResponse registerClinic(ClinicRegisterRequest request);
}
