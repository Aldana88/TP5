package com.inventory.smart.service;

import com.inventory.smart.model.Producto;
import com.inventory.smart.repository.ProductoRepository;

import java.util.List;
import org.springframework.stereotype.Service;



@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto save(Producto producto) {

        if (producto.getStock() < 0) {
            throw new RuntimeException("El stock no puede ser negativo");
        }

        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Long id, Producto producto) {

        Producto existente = findById(id);

        existente.setNombre(producto.getNombre());
        existente.setDescripcion(producto.getDescripcion());
        existente.setPrecio(producto.getPrecio());
        existente.setCategoria(producto.getCategoria());

        return productoRepository.save(existente);
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.buscarPorNombre(nombre);
    }
}