package com.fscordeiro.medreportflow.register.repository;

import com.fscordeiro.medreportflow.register.entity.ClinicDoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicDoctorRepository extends JpaRepository<ClinicDoctorEntity, UUID> {
}
