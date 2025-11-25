package com.fscordeiro.medreportflow.register.mapper;

import com.fscordeiro.medreportflow.register.dto.request.ClinicDoctorRequest;
import com.fscordeiro.medreportflow.register.dto.request.LinkedRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicDoctorResponse;
import com.fscordeiro.medreportflow.register.entity.ClinicDoctorEntity;
import com.fscordeiro.medreportflow.register.entity.DoctorEntity;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.repository.ClinicRepository;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClinicDoctorMapper {

    private final ClinicRepository clinicRepository;
    private final DoctorRepository doctorRepository;


    public ClinicDoctorEntity toClinicDoctorEntity(ClinicDoctorRequest request) {
        var doctor = doctorRepository.findById(request.cpfDoctor())
                .orElseThrow(() -> new NotFoundException("Doctor not found"));

        var clinic = clinicRepository.findById(request.cnpjClinic())
                .orElseThrow(() -> new NotFoundException("Clinic not found"));

        return ClinicDoctorEntity
                .builder()
                .doctor(doctor)
                .clinic(clinic)
                .clinicName(clinic.getName())
                .build();
    }

    public List<ClinicDoctorEntity> toClinicDoctorEntities(DoctorEntity doctor, List<LinkedRequest> linkedRequests) {
        return linkedRequests.stream()
                .map(linked -> {
                    var clinic = clinicRepository.findById(linked.cnpjClinic())
                            .orElseThrow(() -> new NotFoundException(
                                    "Clinic not found: " + linked.cnpjClinic()
                            ));

                    return ClinicDoctorEntity.builder()
                            .doctor(doctor)
                            .clinic(clinic)
                            .clinicName(clinic.getName())
                            .build();
                })
                .toList();
    }

    public ClinicDoctorResponse toClinicDoctorResponse() {
        return ClinicDoctorResponse
                .builder()
                .message("Clinic Doctor Linked")
                .createAt(LocalDateTime.now())
                .build();
    }

}
