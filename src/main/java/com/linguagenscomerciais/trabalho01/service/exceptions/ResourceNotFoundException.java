package com.linguagenscomerciais.trabalho01.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Id " + id + " não encontrado" );
    }
}
