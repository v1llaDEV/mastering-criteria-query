package com.example.jpa.utils;

import com.example.jpa.specifications.GenericSpecification;

import java.lang.reflect.Field;
import java.util.Objects;

public class SearchUtils {

    public static GenericSpecification<?> iterateOverFieldsAddingCriterias(Object objectDto) throws IllegalAccessException {
        Class<?> clazz = objectDto.getClass();
        Field[] fields = clazz.getDeclaredFields();
        GenericSpecification<?> genericSpecification = new GenericSpecification<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            field.setAccessible(true);
            Object fieldValue = field.get(objectDto);
            Class<?> fieldType = field.getType();
            if(!Objects.isNull(fieldValue)){
                if(Number.class.isAssignableFrom(fieldType)){
                    genericSpecification.add(new SearchCriteria(fieldName, fieldValue, SearchOperation.EQUAL));
                }else if(Boolean.class.isAssignableFrom(fieldType)){
                    genericSpecification.add(new SearchCriteria(fieldName, fieldValue, SearchOperation.EQUAL));
                }else{
                    genericSpecification.add(new SearchCriteria(fieldName, fieldValue, SearchOperation.MATCH));
                }
            }
        }

        return genericSpecification;
    }
}
