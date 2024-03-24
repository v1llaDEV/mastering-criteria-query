package com.example.services;

import com.example.dto.DogSearchFilterDto;
import com.example.entities.Dog;

import java.util.List;

public interface DogService {

    List<Dog> getAllDogs();
    Dog getDogById(Long dogId);
    List<Dog> getDogsByAnyAttribute(DogSearchFilterDto dogSearchFilterDto) throws IllegalAccessException;
}
