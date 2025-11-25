package com.fscordeiro.medreportflow.register.mapper;

import com.fscordeiro.medreportflow.register.dto.request.DoctorSpecialtyRequest;
import com.fscordeiro.medreportflow.register.dto.request.LinkedSpecialtyRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorSpecialtyReponse;
import com.fscordeiro.medreportflow.register.entity.DoctorEntity;
import com.fscordeiro.medreportflow.register.entity.DoctorSpecialtyEntity;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.repository.DoctorRepository;
import com.fscordeiro.medreportflow.register.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DoctorSpecialtyMapper {

    private final DoctorRepository doctorRepository;
    private final SpecialtyRepository specialtyRepository;

    public DoctorSpecialtyEntity toDoctorSpecialtyEntity(DoctorSpecialtyRequest request) {
        var doctor = doctorRepository.findById(request.cpfDoctor())
                .orElseThrow(() -> new NotFoundException("Doctor not found"));

        var specialty = specialtyRepository.findById(request.specialty())
                .orElseThrow(() -> new NotFoundException("Clinic not found"));

        return DoctorSpecialtyEntity
                .builder()
                .doctor(doctor)
                .specialty(specialty)
                .specialtyDescription(specialty.getDescription())
                .build();
    }

    public List<DoctorSpecialtyEntity> toDoctorSpecialtyEntities(DoctorEntity doctor, List<LinkedSpecialtyRequest> linkedSpecialtyRequests) {
        return linkedSpecialtyRequests.stream()
                .map(linked -> {
                    var specialty = specialtyRepository.findById(linked.specialty())
                            .orElseThrow(() -> new NotFoundException(
                                    "Clinic not found: " + linked.specialty()
                            ));

                    return DoctorSpecialtyEntity.builder()
                            .doctor(doctor)
                            .specialty(specialty)
                            .specialtyDescription(specialty.getDescription())
                            .build();
                })
                .toList();
    }

    public DoctorSpecialtyReponse toDoctorSpecialtyReponse() {
        return DoctorSpecialtyReponse
                .builder()
                .message("Specialty Doctor Linked")
                .createdAt(LocalDateTime.now())
                .build();
    }

}
