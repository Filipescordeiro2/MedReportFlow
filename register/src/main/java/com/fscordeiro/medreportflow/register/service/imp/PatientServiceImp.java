package com.fscordeiro.medreportflow.register.service.imp;

import com.fscordeiro.medreportflow.register.dto.request.PatientRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.PatientRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.PatientResponse;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.mapper.PatientMapper;
import com.fscordeiro.medreportflow.register.repository.PatientRepository;
import com.fscordeiro.medreportflow.register.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImp implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientRegisterResponse createPatient(PatientRegisterRequest request) {
        try {
            patientRepository.save(patientMapper.toPatientEntity(request));
        }catch (BusinessException | NotFoundException e){
            throw e;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return patientMapper.toPatientRegisterResponse();
    }

    @Override
    public PatientResponse getPatient(String cpf) {
        return patientMapper.toPatientResponse(patientRepository.findById(cpf)
                .orElseThrow(()->new NotFoundException("Patient not found")));
    }
}
