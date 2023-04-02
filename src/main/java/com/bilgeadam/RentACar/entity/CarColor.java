package com.bilgeadam.RentACar.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblcarcolor")
public class CarColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long colorId;
    Long carId;
}
