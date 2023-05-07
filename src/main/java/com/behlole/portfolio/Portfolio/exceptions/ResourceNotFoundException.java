package com.behlole.portfolio.Portfolio.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String fieldName;
    Long value;

    public ResourceNotFoundException(String resourceName, String fieldName, Long value) {
        super(resourceName + " not found with " + fieldName + " : " + value);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.value = value;
    }
}
