package com.inventory.smart.exception;

/**
 * Excepción para reglas de negocio.
 *
 * @author Grupo
 * @since 1.0
 */
public class BusinessRuleException extends RuntimeException {

    public BusinessRuleException(String mensaje) {
        super(mensaje);
    }
}