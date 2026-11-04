package com.linguagenscomerciais.trabalho01.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource not found. Id " + id);
    }

    public ResourceNotFoundException(String element) {
        super("Resource not found. " + element);
    }
}
