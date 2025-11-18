package com.fscordeiro.medreportflow.register.service.imp;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;
import com.fscordeiro.medreportflow.register.mapper.DoctorMapper;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import com.fscordeiro.medreportflow.register.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorRegisterResponse createDoctor(DoctorRegisterRequest request) {
        try {
            doctorRepository.save(doctorMapper.toDoctorEntity(request));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorMapper.toDoctorRegisterResponse();
    }
}
