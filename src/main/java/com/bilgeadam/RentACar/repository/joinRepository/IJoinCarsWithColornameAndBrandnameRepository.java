package com.bilgeadam.RentACar.repository.joinRepository;

import com.bilgeadam.RentACar.entity.jointable.JoinCarsWithColornameAndBrandname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJoinCarsWithColornameAndBrandnameRepository extends JpaRepository<JoinCarsWithColornameAndBrandname, Long> {

    @Query(nativeQuery = true, value = "select c.carid, c.carname, c.model, c.modelyear, c.dailyprice, c.description,\n" +
            "co.colorname, b.brandname from tblcar as c\n" +
            "inner join tblbrand as b on b.brandid = c.brandid\n" +
            "inner join tblcarcolor as cc on cc.car_id = c.carid\n" +
            "inner join tblcolor as co on cc.color_id = co.colorid")
    List<JoinCarsWithColornameAndBrandname> carsWithColorAndBrand();
}
