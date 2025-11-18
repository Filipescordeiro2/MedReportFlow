package com.fscordeiro.medreportflow.register.mapper;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;
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
}
