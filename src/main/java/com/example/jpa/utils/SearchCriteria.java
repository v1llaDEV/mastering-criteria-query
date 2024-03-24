package com.example.jpa.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;
}
