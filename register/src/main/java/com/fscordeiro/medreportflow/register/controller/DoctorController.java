package com.fscordeiro.medreportflow.register.controller;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.DoctorResponse;
import com.fscordeiro.medreportflow.register.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public DoctorRegisterResponse createDoctor(@Valid @RequestBody DoctorRegisterRequest doctorRegisterRequest) {
        return doctorService.createDoctor(doctorRegisterRequest);
    }

    @GetMapping("/{cpf}")
    public DoctorResponse getDoctor(@PathVariable String cpf) {
        return doctorService.findDoctorById(cpf);
    }
}
