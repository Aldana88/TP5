package com.inventory.smart.repository;

import com.inventory.smart.model.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCategoriaRepository
        extends GenericInMemoryRepository<Categoria, Long>
        implements CategoriaRepository {
}