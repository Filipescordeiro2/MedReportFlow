package com.fscordeiro.medreportflow.register.mapper;


import com.fscordeiro.medreportflow.register.dto.request.SpecialtyRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyResponse;
import com.fscordeiro.medreportflow.register.entity.SpecialtyEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SpecialtyMapper {

    public SpecialtyEntity toSpecialtyEntity(SpecialtyRegisterRequest registerRequest) {
        return SpecialtyEntity
                .builder()
                .specialty(registerRequest.specialty())
                .description(registerRequest.description())
                .build();
    }

    public SpecialtyRegisterResponse toSpecialtyRegisterResponse() {
        return SpecialtyRegisterResponse
                .builder()
                .message("Specialty registered")
                .createdAt(LocalDateTime.now())
                .build();
    }

    public SpecialtyResponse toSpecialtyResponse(SpecialtyEntity specialtyEntity) {
        return SpecialtyResponse
                .builder()
                .specialty(specialtyEntity.getSpecialty())
                .description(specialtyEntity.getDescription())
                .createdAt(specialtyEntity.getCreatedAt())
                .updatedAt(specialtyEntity.getUpdatedAt())
                .active(specialtyEntity.getActive())
                .build();
    }

}
