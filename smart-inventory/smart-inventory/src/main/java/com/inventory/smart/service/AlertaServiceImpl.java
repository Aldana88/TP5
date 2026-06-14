package com.inventory.smart.service;

import com.inventory.smart.model.Producto;
import com.inventory.smart.repository.ProductoRepository;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AlertaServiceImpl implements AlertaService {

    private final ProductoRepository productoRepository;

    private static final int STOCK_MINIMO = 10;

    public AlertaServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> obtenerProductosEnAlerta() {

        return productoRepository.findAll()
                .stream()
                .filter(producto -> producto.getStock() < STOCK_MINIMO)
                .toList();
    }
}