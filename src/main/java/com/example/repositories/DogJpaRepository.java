package com.example.repositories;

import com.example.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DogJpaRepository extends JpaRepository<Dog, Long>, JpaSpecificationExecutor<Dog> {
}
