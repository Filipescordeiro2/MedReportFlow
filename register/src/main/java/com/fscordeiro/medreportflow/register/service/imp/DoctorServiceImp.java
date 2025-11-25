package com.fscordeiro.medreportflow.register.service.imp;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.DoctorResponse;
import com.fscordeiro.medreportflow.register.entity.DoctorEntity;
import com.fscordeiro.medreportflow.register.exception.BusinessException;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.mapper.ClinicDoctorMapper;
import com.fscordeiro.medreportflow.register.mapper.DoctorMapper;
import com.fscordeiro.medreportflow.register.mapper.DoctorSpecialtyMapper;
import com.fscordeiro.medreportflow.register.repository.ClinicDoctorRepository;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import com.fscordeiro.medreportflow.register.repository.DoctorSpecialtyRepository;
import com.fscordeiro.medreportflow.register.service.DoctorService;
import com.fscordeiro.medreportflow.register.strategy.doctor.DoctorValidationExecutor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorServiceImp implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final ClinicDoctorRepository clinicDoctorRepository;
    private final DoctorSpecialtyRepository doctorSpecialtyRepository;
    private final ClinicDoctorMapper clinicDoctorMapper;
    private final DoctorSpecialtyMapper doctorSpecialtyMapper;
    private final DoctorValidationExecutor validationExecutor;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorRegisterResponse createDoctor(DoctorRegisterRequest request) {
        log.info("Initializing the service [DoctorServiceImp - createDoctor] - request: {}", request);
        try {
            validationExecutor.execute(request);
            var doctor = doctorRepository.save(doctorMapper.toDoctorEntity(request));

            linkDoctorToClinics(doctor, request);
            linkDoctorToSpecialty(doctor, request);
        } catch (BusinessException | NotFoundException e){
            log.error("Error the service [DoctorServiceImp - createDoctor] - message:{}",e.getMessage());
            throw e;
        } catch (Exception e) {
            log.error("RuntimeException the service [DoctorServiceImp - createDoctor] - message:{}",e.getMessage());
            throw new RuntimeException(e);
        }
        return doctorMapper.toDoctorRegisterResponse();
    }

    @Override
    public DoctorResponse findDoctorById(String cpf) {
        log.info("Initializing service [DoctorServiceImp - findDoctorById] - cpf: {}", cpf);

        var doctor = doctorRepository.findById(cpf)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));

        log.info("Successfully retrieved doctor [DoctorServiceImp - findDoctorById] - response: {}", doctor.toString());

        return doctorMapper.toDoctorResponse(doctor);
    }

    private void linkDoctorToClinics(DoctorEntity doctor, DoctorRegisterRequest request) {
        if (request.linked() == null || request.linked().isEmpty()) {
            return;
        }
        var clinicLinks = clinicDoctorMapper.toClinicDoctorEntities(doctor, request.linked());
        clinicDoctorRepository.saveAll(clinicLinks);
        log.info("Linked {} clinics to doctor {}", clinicLinks.size(), doctor.getCpf());
    }

    private void linkDoctorToSpecialty(DoctorEntity doctor, DoctorRegisterRequest request) {
        if (request.linkedSpecialty()== null || request.linkedSpecialty().isEmpty()) {
            return;
        }
        var specialtyLinks = doctorSpecialtyMapper.toDoctorSpecialtyEntities(doctor, request.linkedSpecialty());
        doctorSpecialtyRepository.saveAll(specialtyLinks);
        log.info("Linked {} doctor to specialtys {}", specialtyLinks.size(), doctor.getCpf());
    }



}
