package com.example.dto.filters;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DogSearchFilterDto {

    private Long id;
    private String name;
    private String breed;
    private LocalDate birthday;
    private String color;
    private Boolean vaccinated;
}
