package com.bilgeadam.RentACar.entity.jointable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tblcarswithcolornameandbrandname")
public class JoinCarsWithColornameAndBrandname {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carid")
    Long id;
    String carname;
    String model;
    int modelyear;
    double dailyprice;
    String description;
    String colorname;
    String brandname;

}
