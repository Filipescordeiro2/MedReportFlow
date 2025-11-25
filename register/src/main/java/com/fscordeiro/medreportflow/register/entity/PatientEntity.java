package com.fscordeiro.medreportflow.register.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient-db")
public class PatientEntity {

    @Id
    private String cpf;

    private String name;
    private String surname;
    private String gender;
    private LocalDate birthDate;
    private Integer age;
    private String phone;
    private String email;
    private String password;

    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;

    @PrePersist()
    public void prePersist() {
        age = LocalDateTime.now().getYear() - birthDate.getYear();
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        active = true;
    }

    @PreUpdate()
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
