package com.bilgeadam.RentACar.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveCarRequestDto {

    String name;
    Long brandid;
    List<Long> colorids;
    String model;
    int modelyear;
    double dailyprice;
    String description;
}
