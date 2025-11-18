package com.fscordeiro.medreportflow.register.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor-db")
public class DoctorEntity {

    @Id
    private String cpf;

    private String name;
    private String email;
    private String phone;
    private String typeRegulatory;
    private String numberRegulatory;
    private String gender;
    private LocalDate birthDate;
    private Integer age;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;

    @PrePersist
    public void prePersist() {
        age = LocalDateTime.now().getYear() - birthDate.getYear();
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        active = true;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
