package com.bilgeadam.RentACar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblcar")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carid")
    Long id;
    @NotBlank
    @Column(name = "carname")
    String name;
    @NotBlank
    String model;
    @NotNull
    int modelyear;
    @NotNull
    double dailyprice;
    @NotBlank
    String description;
    @NotNull
    Long brandid;
}
