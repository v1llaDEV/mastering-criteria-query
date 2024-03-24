package com.example.controllers;

import com.example.dto.filters.DogSearchFilterDto;
import com.example.dto.responses.DogResponseDto;
import com.example.entities.Dog;
import com.example.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dogs")
@RequiredArgsConstructor
public class DogRestController {

    private final DogService dogService;

    @GetMapping
    public List<DogResponseDto> getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/{dogId}")
    public DogResponseDto getDogById(@PathVariable Long dogId){
        return dogService.getDogById(dogId);
    }

    @PostMapping("/search")
    public List<DogResponseDto> getDogsByAnyAttribute(@RequestBody DogSearchFilterDto dogSearchFilterDto) throws IllegalAccessException {
        return dogService.getDogsByAnyAttribute(dogSearchFilterDto);
    }

}
