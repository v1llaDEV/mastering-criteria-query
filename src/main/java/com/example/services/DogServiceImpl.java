package com.example.services;

import com.example.dto.filters.DogSearchFilterDto;
import com.example.dto.responses.DogResponseDto;
import com.example.entities.Dog;
import com.example.jpa.specifications.GenericSpecification;
import com.example.jpa.utils.SearchUtils;
import com.example.repositories.DogJpaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class DogServiceImpl implements DogService{

    private final DogJpaRepository dogJpaRepository;
    private final ObjectMapper objectMapper;

    public List<DogResponseDto> getAllDogs(){
        List<Dog> dogListEntity = dogJpaRepository.findAll();
        return Arrays.asList(objectMapper.convertValue(dogListEntity, DogResponseDto[].class));
    }

    public DogResponseDto getDogById(Long dogId){
        Dog dogEntity = dogJpaRepository.findById(dogId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        return objectMapper.convertValue(dogEntity, DogResponseDto.class);
    }
    public List<DogResponseDto> getDogsByAnyAttribute(DogSearchFilterDto dogSearchFilterDto) throws IllegalAccessException {
        GenericSpecification<Dog> genericSpecification =
                (GenericSpecification<Dog>) SearchUtils.iterateOverFieldsAddingCriterias(dogSearchFilterDto);
        List<Dog> dogListEntity = dogJpaRepository.findAll(genericSpecification);
        return Arrays.asList(objectMapper.convertValue(dogListEntity, DogResponseDto[].class));
    }
}
