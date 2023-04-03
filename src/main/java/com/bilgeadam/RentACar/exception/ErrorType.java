package com.bilgeadam.RentACar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    CAR_NOT_FOUND(2004,"Aradığınız araba veritabanında bulunamadı", HttpStatus.NOT_FOUND),
    BRAND_NOT_FOUND(2005,"Aradığınız marka veritabanında bulunamadı", HttpStatus.NOT_FOUND),
    CUSTOMER_NOT_FOUND(2006,"Aradığınız müşteri veritabanında bulunamadı", HttpStatus.NOT_FOUND),
    RENTAL_NOT_FOUND(2007,"Aradığınız kiralama veritabanında bulunamadı", HttpStatus.NOT_FOUND),
    COLOR_NOT_FOUND(2008,"Aradığınız renk veritabanında bulunamadı", HttpStatus.NOT_FOUND),
    CUSTOMER_OR_CAR_NOT_FOUND(2009,"Girdiğiniz müşteri ve araba veritabanında bulunamadı", HttpStatus.NOT_FOUND),
    BRAND_FOUND(5001,"Aradığınız marka zaten veritabanında var.", HttpStatus.FOUND),
    COLOR_FOUND(5002,"Aradığınız renk zaten veritabanında var.", HttpStatus.FOUND),
    BAD_REQUEST(4000,"Geçersiz istek ya da parametre", HttpStatus.BAD_REQUEST),
    ERROR_INVALID_TOKEN(3000,"Geçersiz token bilgisi", HttpStatus.UNAUTHORIZED),
    ERROR(9000, "Beklenmeyen bir hata oluştur. Lütfen tekrar deneyiniz.", HttpStatus.INTERNAL_SERVER_ERROR)  ;

    int code;
    String message;
    HttpStatus httpStatus;

}
