package com.fscordeiro.medreportflow.register.mapper;

import com.fscordeiro.medreportflow.register.dto.request.ClinicRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.AddressResponse;
import com.fscordeiro.medreportflow.register.dto.response.ClinicRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.ClinicReponse;
import com.fscordeiro.medreportflow.register.entity.ClinicEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClinicMapper {

    public ClinicEntity toClinicEntity(ClinicRegisterRequest request) {
        return ClinicEntity
                .builder()
                .name(request.name())
                .cnpj(request.cnpj())
                .description(request.description())
                .phone(request.phone())
                .email(request.email())
                .address(request.addressClinic().address())
                .city(request.addressClinic().city())
                .state(request.addressClinic().state())
                .zip(request.addressClinic().zip())
                .country(request.addressClinic().country())
                .build();
    }

    public ClinicRegisterResponse toClinicRegisterResponse() {
        return ClinicRegisterResponse
                .builder()
                .message("Clinic register successfully")
                .createdAt(LocalDateTime.now())
                .build();
    }

    public ClinicReponse toClinicReponse(ClinicEntity entity) {
        return ClinicReponse
                .builder()
                .cnpj(entity.getCnpj())
                .name(entity.getName())
                .description(entity.getDescription())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .addressClinic(
                        AddressResponse.builder()
                                .address(entity.getAddress())
                                .city(entity.getCity())
                                .state(entity.getState())
                                .zip(entity.getZip())
                                .country(entity.getCountry())
                                .build()
                )
                .build();
    }

}
