package com.inventory.smart.service;

import com.inventory.smart.model.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> findAll();

    Categoria findById(Long id);

    Categoria save(Categoria categoria);

    Categoria update(Long id, Categoria categoria);

    void deleteById(Long id);
}