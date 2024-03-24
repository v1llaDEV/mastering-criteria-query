package com.example.controllers;

import com.example.entities.Dog;
import com.example.repositories.DogJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dogs")
@RequiredArgsConstructor
public class DogRestController {

    private final DogJpaRepository dogJpaRepository;

    @GetMapping
    public List<Dog> getAllDogs(){
        return dogJpaRepository.findAll();
    }

    @GetMapping("/{dogId}")
    public Dog getAllDogs(@PathVariable Long dogId){
        return dogJpaRepository.findById(dogId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }

}
