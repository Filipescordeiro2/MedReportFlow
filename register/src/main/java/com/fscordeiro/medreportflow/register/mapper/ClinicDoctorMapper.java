package com.fscordeiro.medreportflow.register.mapper;

import com.fscordeiro.medreportflow.register.dto.request.ClinicDoctorRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicDoctorResponse;
import com.fscordeiro.medreportflow.register.entity.ClinicDoctorEntity;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.repository.ClinicRepository;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ClinicDoctorMapper {

    private final ClinicRepository clinicRepository;
    private final DoctorRepository doctorRepository;


    public ClinicDoctorEntity toClinicDoctorEntity (ClinicDoctorRequest request) {
        var doctor = doctorRepository.findById(request.cpfDoctor())
                .orElseThrow(()-> new NotFoundException("Doctor not found"));

        var clinic = clinicRepository.findById(request.cnpjClinic())
                .orElseThrow(()-> new NotFoundException("Clinic not found"));

        return ClinicDoctorEntity
                .builder()
                .doctor(doctor)
                .clinic(clinic)
                .clinicName(clinic.getName())
                .build();
    }

    public ClinicDoctorResponse toClinicDoctorResponse() {
        return ClinicDoctorResponse
                .builder()
                .message("Clinic Doctor Linked")
                .createAt(LocalDateTime.now())
                .build();
    }

}
