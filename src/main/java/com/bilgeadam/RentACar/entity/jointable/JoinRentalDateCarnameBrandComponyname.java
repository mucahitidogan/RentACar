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
@Table(name = "tblrentaldatecarcompony")
public class JoinRentalDateCarnameBrandComponyname {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carid")
    Long id;
    Long rentdate;
    String carname;
    String brandname;
    String companyname;
}
