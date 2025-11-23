package com.fscordeiro.medreportflow.register.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clinic-doctor-db")
public class ClinicDoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "doctor_cpf", nullable = false)
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(name = "clinic_cnpj", nullable = false)
    private ClinicEntity clinic;

    private String clinicName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;

    @PrePersist()
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        active = true;
    }

    @PreUpdate()
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
