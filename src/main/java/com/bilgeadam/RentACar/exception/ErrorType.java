package com.bilgeadam.RentACar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    BOOK_NOT_FOUND(2004,"Aradığınız veri veri tabanında bulunamadı", HttpStatus.NOT_FOUND),
    BAD_REQUEST(4000,"Geçersiz istek ya da parametre", HttpStatus.BAD_REQUEST),
    ERROR_INVALID_TOKEN(3000,"Geçersiz token bilgisi", HttpStatus.UNAUTHORIZED),
    ERROR(9000, "Beklenmeyen bir hata oluştur. Lütfen tekrar deneyiniz.", HttpStatus.INTERNAL_SERVER_ERROR)  ;

    int code;
    String message;
    HttpStatus httpStatus;

}
