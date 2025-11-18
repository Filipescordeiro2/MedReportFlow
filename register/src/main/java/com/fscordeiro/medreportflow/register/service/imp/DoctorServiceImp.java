package com.fscordeiro.medreportflow.register.service.imp;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.DoctorResponse;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.mapper.DoctorMapper;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import com.fscordeiro.medreportflow.register.service.DoctorService;
import com.fscordeiro.medreportflow.register.strategy.doctor.DoctorValidationExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorValidationExecutor validationExecutor;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorRegisterResponse createDoctor(DoctorRegisterRequest request) {
        validationExecutor.execute(request);
        try {
            doctorRepository.save(doctorMapper.toDoctorEntity(request));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return doctorMapper.toDoctorRegisterResponse();
    }

    @Override
    public DoctorResponse findDoctorById(String cpf) {
        return doctorMapper.toDoctorResponse(doctorRepository.findById(cpf)
                .orElseThrow(()-> new NotFoundException("Doctor not found")));
    }
}
