package com.fscordeiro.medreportflow.register.repository;

import com.fscordeiro.medreportflow.register.entity.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpecialtyRepository extends JpaRepository<SpecialtyEntity, String> {
    Optional<SpecialtyEntity> findBySpecialty(String specialty);
    List<SpecialtyEntity> findAllBySpecialtyIn(List<String> specialties);

}
