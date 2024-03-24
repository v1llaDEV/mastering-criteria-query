package com.example.controllers;

import com.example.dto.DogSearchFilterDto;
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
    public List<Dog> getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/{dogId}")
    public Dog getDogById(@PathVariable Long dogId){
        return dogService.getDogById(dogId);
    }

    @PostMapping("/search")
    public List<Dog> getDogsByAnyAttribute(@RequestBody DogSearchFilterDto dogSearchFilterDto) throws IllegalAccessException {
        return dogService.getDogsByAnyAttribute(dogSearchFilterDto);
    }

}
