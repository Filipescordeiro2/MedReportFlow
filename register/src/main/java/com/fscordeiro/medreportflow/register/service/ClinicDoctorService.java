package com.fscordeiro.medreportflow.register.service;

import com.fscordeiro.medreportflow.register.dto.request.ClinicDoctorRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicDoctorResponse;

public interface ClinicDoctorService {

    public ClinicDoctorResponse linkedClinicDoctor(ClinicDoctorRequest request);
}
