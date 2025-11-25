package com.fscordeiro.medreportflow.register.repository;

import com.fscordeiro.medreportflow.register.entity.ClinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClinicRepository extends JpaRepository<ClinicEntity, String> {
    List<ClinicEntity> findAllByCnpjIn(List<String> cnpjs);

}
