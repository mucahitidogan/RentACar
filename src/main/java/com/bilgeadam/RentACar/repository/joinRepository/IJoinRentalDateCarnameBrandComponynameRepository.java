package com.bilgeadam.RentACar.repository.joinRepository;

import com.bilgeadam.RentACar.entity.jointable.JoinRentalDateCarnameBrandComponyname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJoinRentalDateCarnameBrandComponynameRepository extends JpaRepository<JoinRentalDateCarnameBrandComponyname, Long> {

    @Query(nativeQuery = true, value = "select c.carid, r.rentdate, c.carname, b.brandname, cus.companyname\n" +
            "from tblcar as c inner join tblrental as r on c.carid = r.carid\n" +
            "inner join tblcustomer as cus on cus.customerid = r.customerid\n" +
            "inner join tblbrand as b on b.brandid = c.brandid")
    List<JoinRentalDateCarnameBrandComponyname> findDateBrandCompanyCarName();
}
