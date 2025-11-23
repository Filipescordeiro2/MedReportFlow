package com.fscordeiro.medreportflow.register.service.imp;

import com.fscordeiro.medreportflow.register.dto.request.ClinicRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicRegisterResponse;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.mapper.ClinicMapper;
import com.fscordeiro.medreportflow.register.repository.ClinicRepository;
import com.fscordeiro.medreportflow.register.service.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicServiceImp implements ClinicService {

    private final ClinicRepository clinicRepository;
    private  final ClinicMapper clinicMapper;

    @Override
    public ClinicRegisterResponse registerClinic(ClinicRegisterRequest request) {
        try{
            clinicRepository.save(clinicMapper.toClinicEntity(request));
        }catch (BusinessException | NullPointerException e){
            throw e;
        }catch (Exception e){
            throw new BusinessException(e.getMessage());
        }
        return clinicMapper.toClinicRegisterResponse();
    }
}
