package com.inventory.smart.exception;

/**
 * @author Grupo
 * @since 1.0
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}