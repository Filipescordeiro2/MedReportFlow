package com.fscordeiro.medreportflow.register.repository;

import com.fscordeiro.medreportflow.register.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity,String> {
}
