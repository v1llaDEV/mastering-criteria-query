package com.example.services;

import com.example.dto.filters.DogSearchFilterDto;
import com.example.dto.responses.DogResponseDto;
import com.example.entities.Dog;

import java.util.List;

public interface DogService {

    List<DogResponseDto> getAllDogs();
    DogResponseDto getDogById(Long dogId);
    List<DogResponseDto> getDogsByAnyAttribute(DogSearchFilterDto dogSearchFilterDto) throws IllegalAccessException;
}
