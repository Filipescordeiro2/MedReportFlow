package com.fscordeiro.medreportflow.register.controller;

import com.fscordeiro.medreportflow.register.dto.request.SpecialtyRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyRegisterResponse;
import com.fscordeiro.medreportflow.register.dto.response.SpecialtyResponse;
import com.fscordeiro.medreportflow.register.service.SpecialtyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/specialty")
@RequiredArgsConstructor
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    @PostMapping
    public SpecialtyRegisterResponse createSpecialty(@Valid @RequestBody SpecialtyRegisterRequest request) {
        return specialtyService.createSpecialty(request);
    }

    @GetMapping("/{specialtyId}")
    public SpecialtyResponse getSpecialty(@PathVariable UUID specialtyId) {
        return specialtyService.getSpecialty(specialtyId);
    }
}
