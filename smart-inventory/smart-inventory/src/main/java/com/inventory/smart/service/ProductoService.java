package com.inventory.smart.service;

import com.inventory.smart.model.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> findAll();

    Producto findById(Long id);

    Producto save(Producto producto);

    Producto update(Long id, Producto producto);

    void deleteById(Long id);

    List<Producto> buscarPorNombre(String nombre);
}