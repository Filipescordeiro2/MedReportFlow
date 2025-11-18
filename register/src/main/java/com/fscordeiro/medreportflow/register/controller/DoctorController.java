package com.fscordeiro.medreportflow.register.controller;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.response.DoctorRegisterResponse;
import com.fscordeiro.medreportflow.register.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/doctor")
    public DoctorRegisterResponse createDoctor(@RequestBody DoctorRegisterRequest doctorRegisterRequest) {
        return doctorService.createDoctor(doctorRegisterRequest);
    }

}
