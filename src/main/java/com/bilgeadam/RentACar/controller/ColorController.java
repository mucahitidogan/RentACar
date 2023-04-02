package com.bilgeadam.RentACar.controller;

import com.bilgeadam.RentACar.dto.request.SaveColorRequestDto;
import com.bilgeadam.RentACar.entity.Color;
import com.bilgeadam.RentACar.mapper.IColorMapper;
import com.bilgeadam.RentACar.service.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.bilgeadam.RentACar.constants.EndPointList.*;

@RestController
@RequestMapping(COLOR)
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;

    @PostMapping(SAVE)
    public ResponseEntity<Color> save(@RequestBody @Valid SaveColorRequestDto dto){
        colorService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Color>> findAll(){
        return ResponseEntity.ok(colorService.findAll());
    }
}
