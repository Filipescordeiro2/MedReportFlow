package com.fscordeiro.medreportflow.register.controller;

import com.fscordeiro.medreportflow.register.dto.request.ClinicDoctorRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicDoctorResponse;
import com.fscordeiro.medreportflow.register.service.ClinicDoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/clinicDoctor")
@RequiredArgsConstructor
public class ClinicDoctorController {

    private final ClinicDoctorService clinicDoctorService;

    @PostMapping("/linked")
    public ClinicDoctorResponse linkedClinicDoctor(@Valid @RequestBody ClinicDoctorRequest request) {
       return clinicDoctorService.linkedClinicDoctor(request);
    }
}
