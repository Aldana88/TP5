package com.inventory.smart.exception;

/**
 * Excepción lanzada cuando no hay stock suficiente.
 *
 * @author Grupo
 * @since 1.0
 */
public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException(String mensaje) {
        super(mensaje);
    }
}