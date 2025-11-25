package com.fscordeiro.medreportflow.register.strategy.doctor;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.request.LinkedRequest;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClinicExistsValidation implements DoctorValidation {

    private final ClinicRepository clinicRepository;

    @Override
    public void validate(DoctorRegisterRequest request) {

        var linkedClinics = request.linked();

        if (linkedClinics == null || linkedClinics.isEmpty()) {
            return;
        }
        var cnpjList = linkedClinics.stream()
                .map(LinkedRequest::cnpjClinic)
                .toList();
        var existing = clinicRepository.findAllByCnpjIn(cnpjList);
        if (existing.size() != cnpjList.size()) {
            var notFound = cnpjList.stream()
                    .filter(cnpj -> existing.stream()
                            .noneMatch(db -> db.getCnpj().equals(cnpj))).toList();
            throw new NotFoundException("Clinics not found: " + notFound);
        }
    }
}
