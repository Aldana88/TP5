package com.inventory.smart.repository;

import com.inventory.smart.model.Producto;

import java.util.List;

public interface ProductoRepository
        extends IGenericRepository<Producto, Long> {

    List<Producto> findByCategoria(Long categoriaId);

    List<Producto> buscarPorNombre(String texto);
}