package com.inventory.smart.model;

import java.time.LocalDateTime;

public class MovimientoInventario {

    private Long id;
    private Producto producto;
    private TipoMovimiento tipo;
    private int cantidad;
    private String motivo;
    private LocalDateTime fecha;

    public MovimientoInventario() {
        this.fecha = LocalDateTime.now();
    }

    public MovimientoInventario(Long id,
                                Producto producto,
                                TipoMovimiento tipo,
                                int cantidad,
                                String motivo) {

        this.id = id;
        this.producto = producto;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}