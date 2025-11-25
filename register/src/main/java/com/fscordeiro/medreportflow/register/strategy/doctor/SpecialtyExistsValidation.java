package com.fscordeiro.medreportflow.register.strategy.doctor;

import com.fscordeiro.medreportflow.register.dto.request.DoctorRegisterRequest;
import com.fscordeiro.medreportflow.register.dto.request.LinkedSpecialtyRequest;
import com.fscordeiro.medreportflow.register.exception.NotFoundException;
import com.fscordeiro.medreportflow.register.repository.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpecialtyExistsValidation implements DoctorValidation {

    private final SpecialtyRepository specialtyRepository;

    @Override
    public void validate(DoctorRegisterRequest request) {
        var linkedSpecialties = request.linkedSpecialty();

        if (linkedSpecialties == null || linkedSpecialties.isEmpty()) {
            return;
        }

        var specialtyNames = linkedSpecialties.stream()
                .map(LinkedSpecialtyRequest::specialty)
                .toList();

        var existing = specialtyRepository.findAllBySpecialtyIn(specialtyNames);

        if (existing.size() != specialtyNames.size()) {
            var notFound = specialtyNames.stream()
                    .filter(spec -> existing.stream()
                            .noneMatch(db -> db.getSpecialty().equals(spec))).toList();

            throw new NotFoundException("Specialties not found: " + notFound);
        }
    }
}
