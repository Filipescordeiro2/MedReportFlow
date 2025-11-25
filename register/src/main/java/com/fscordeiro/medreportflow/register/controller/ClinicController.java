package com.fscordeiro.medreportflow.register.controller;

import com.fscordeiro.medreportflow.register.dto.request.ClinicRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.ClinicRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.ClinicReponse;
import com.fscordeiro.medreportflow.register.service.ClinicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clinic")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @PostMapping
    public ClinicRegisterResponse registerClinic(@Valid @RequestBody ClinicRegisterRequest request) {
        return clinicService.registerClinic(request);
    }

    @GetMapping("/{cnpj}")
    public ClinicReponse getClinic(@PathVariable String cnpj) {
        return clinicService.getClinic(cnpj);
    }
}
