package com.example.dto.responses;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class DogResponseDto implements Serializable {

    private Long id;
    private String name;
    private String breed;
    private LocalDate birthday;
    private String color;
    private Boolean vaccinated;
}
