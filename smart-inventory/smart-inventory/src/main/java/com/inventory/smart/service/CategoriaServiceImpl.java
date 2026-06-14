package com.inventory.smart.service;

import com.inventory.smart.model.Categoria;
import com.inventory.smart.repository.CategoriaRepository;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {


    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Long id, Categoria categoria) {

        Categoria existente = findById(id);

        existente.setNombre(categoria.getNombre());
        existente.setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}