package com.fscordeiro.medreportflow.register.repository;

import com.fscordeiro.medreportflow.register.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorEntity,String> {
    Optional<DoctorEntity> findByNumberRegulatoryAndStateAndTypeRegulatory(String numberRegulatory, String state, String type);
}
