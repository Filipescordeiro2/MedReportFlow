package com.fscordeiro.medreportflow.register.mapper;

import com.fscordeiro.medreportflow.register.dto.request.PatientRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.AddressResponse;
import com.fscordeiro.medreportflow.register.dto.response.PatientRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.PatientResponse;
import com.fscordeiro.medreportflow.register.entity.PatientEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PatientMapper {

    public PatientRegisterResponse toPatientRegisterResponse(){
        return PatientRegisterResponse
                .builder()
                .message("Patient Register")
                .createdAt(LocalDateTime.now())
                .build();
    }

    public PatientEntity toPatientEntity(PatientRegisterRequest request) {
        return PatientEntity
                .builder()
                .cpf(request.cpf())
                .name(request.name())
                .surname(request.surname())
                .gender(request.gender())
                .birthDate(request.birthDate())
                .phone(request.phone())
                .email(request.email())
                .password(request.password())
                .address(request.address().address())
                .city(request.address().city())
                .state(request.address().state())
                .zip(request.address().zip())
                .country(request.address().country())
                .build();
    }

    public PatientResponse toPatientResponse(PatientEntity entity) {
        return PatientResponse
                .builder()
                .cpf(entity.getCpf())
                .name(entity.getName())
                .surname(entity.getSurname())
                .gender(entity.getGender())
                .birthDate(entity.getBirthDate())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .age(entity.getAge())
                .updatedAt(entity.getUpdatedAt())
                .createdAt(entity.getCreatedAt())
                .active(entity.getActive())
                .address(
                        AddressResponse.builder()
                                .address(entity.getAddress())
                                .city(entity.getCity())
                                .state(entity.getState())
                                .zip(entity.getZip())
                                .country(entity.getCountry())
                                .build()
                ).build();
    }
}
