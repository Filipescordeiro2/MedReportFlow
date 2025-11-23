package com.fscordeiro.medreportflow.register.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clinic-db")
public class ClinicEntity {

    @Id
    private String cnpj;

    @OneToMany(mappedBy = "clinic", cascade = CascadeType.ALL)
    private List<ClinicDoctorEntity> doctors;

    private String name;
    private String description;
    private String phone;
    private String email;

    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        active = true;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
