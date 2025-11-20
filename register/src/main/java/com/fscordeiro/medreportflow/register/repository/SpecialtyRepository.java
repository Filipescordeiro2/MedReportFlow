package com.fscordeiro.medreportflow.register.repository;

import com.fscordeiro.medreportflow.register.entity.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity, UUID> {
    Optional<SpecialtyEntity> findBySpecialty(String specialty);
}
