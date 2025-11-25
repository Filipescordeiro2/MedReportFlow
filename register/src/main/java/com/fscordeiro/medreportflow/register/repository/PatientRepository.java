package com.fscordeiro.medreportflow.register.repository;

import com.fscordeiro.medreportflow.register.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity,String> {
}
