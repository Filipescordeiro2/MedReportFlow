package com.fscordeiro.medreportflow.register.mapper;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.DoctorResponse;
import com.fscordeiro.medreportflow.register.entity.DoctorEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DoctorMapper {

    public DoctorEntity toDoctorEntity(DoctorRegisterRequest request) {
        return DoctorEntity
                .builder()
                .cpf(request.cpf())
                .phone(request.phone())
                .name(request.name())
                .email(request.email())
                .typeRegulatory(request.typeRegulatory())
                .gender(request.gender())
                .birthDate(request.birthDate())
                .numberRegulatory(request.numberRegulatory())
                .build();
    }

    public DoctorRegisterResponse toDoctorRegisterResponse() {
        return DoctorRegisterResponse
                .builder()
                .message("Doctor registered")
                .createdAt(LocalDateTime.now())
                .build();
    }

    public DoctorResponse toDoctorResponse(DoctorEntity doctorEntity) {
        return DoctorResponse
                .builder()
                .cpf(maskedLabel(doctorEntity.getCpf()))
                .name(doctorEntity.getName())
                .email(doctorEntity.getEmail())
                .phone(doctorEntity.getPhone())
                .typeRegulatory(doctorEntity.getTypeRegulatory())
                .numberRegulatory(maskedLabel(doctorEntity.getNumberRegulatory()))
                .gender(doctorEntity.getGender())
                .birthDate(doctorEntity.getBirthDate())
                .age(doctorEntity.getAge())
                .createdAt(doctorEntity.getCreatedAt())
                .updatedAt(doctorEntity.getUpdatedAt())
                .active(doctorEntity.getActive())
                .build();
    }

    private String maskedLabel(String label) {

        if (label == null || label.isBlank()) {
            return label;
        }

        int length = label.length();

        if (length <= 4) {
            return label.charAt(0) + "*".repeat(length - 1);
        }

        var start = label.substring(0, 2);
        var end = label.substring(length - 2);
        var masked = "*".repeat(length - 4);

        return start + masked + end;
    }

}
