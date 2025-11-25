package com.fscordeiro.medreportflow.register.controller;

import com.fscordeiro.medreportflow.register.dto.request.PatientRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.PatientRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.PatientResponse;
import com.fscordeiro.medreportflow.register.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public PatientRegisterResponse createPatient(@Valid @RequestBody PatientRegisterRequest request) {
        return patientService.createPatient(request);
    }

    @GetMapping("/{cpf}")
    public PatientResponse getPatient(@PathVariable String cpf) {
        return patientService.getPatient(cpf);
    }
}
