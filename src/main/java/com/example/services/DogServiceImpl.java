package com.example.services;

import com.example.dto.DogSearchFilterDto;
import com.example.entities.Dog;
import com.example.jpa.specifications.GenericSpecification;
import com.example.jpa.utils.SearchUtils;
import com.example.repositories.DogJpaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class DogServiceImpl implements DogService{

    private final DogJpaRepository dogJpaRepository;

    public List<Dog> getAllDogs(){
        return dogJpaRepository.findAll();
    }

    public Dog getDogById(Long dogId){
        return dogJpaRepository.findById(dogId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
    }
    public List<Dog> getDogsByAnyAttribute(DogSearchFilterDto dogSearchFilterDto) throws IllegalAccessException {
        GenericSpecification<Dog> genericSpecification =
                (GenericSpecification<Dog>) SearchUtils.iterateOverFieldsAddingCriterias(dogSearchFilterDto);
        return dogJpaRepository.findAll(genericSpecification);
    }
}
