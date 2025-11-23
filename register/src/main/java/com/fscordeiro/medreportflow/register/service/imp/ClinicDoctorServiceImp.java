package com.fscordeiro.medreportflow.register.service.imp;

import com.fscordeiro.medreportflow.register.dto.request.ClinicDoctorRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicDoctorResponse;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.mapper.ClinicDoctorMapper;
import com.fscordeiro.medreportflow.register.repository.ClinicDoctorRepository;
import com.fscordeiro.medreportflow.register.service.ClinicDoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicDoctorServiceImp implements ClinicDoctorService {

    private final ClinicDoctorRepository clinicDoctorRepository;
    private final ClinicDoctorMapper clinicDoctorMapper;

    @Override
    public ClinicDoctorResponse linkedClinicDoctor(ClinicDoctorRequest clinicDoctorRequest) {
        try {
            clinicDoctorRepository.save(clinicDoctorMapper.toClinicDoctorEntity(clinicDoctorRequest));
        }catch (BusinessException | NotFoundException e){
            throw e;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return clinicDoctorMapper.toClinicDoctorResponse();
    }
}
