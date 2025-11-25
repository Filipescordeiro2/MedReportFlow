package com.fscordeiro.medreportflow.register.service;

import com.fscordeiro.medreportflow.register.dto.request.PatientRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.PatientRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.PatientResponse;

public interface PatientService {
    public PatientRegisterResponse createPatient(PatientRegisterRequest request);
    public PatientResponse getPatient(String cpf);


}
