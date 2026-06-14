package com.inventory.smart.repository;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class GenericInMemoryRepository<T, ID>
        implements IGenericRepository<T, ID> {

    protected final ConcurrentHashMap<ID, T> dataStore =
            new ConcurrentHashMap<>();

    protected final AtomicLong idGenerator =
            new AtomicLong(0);

    @Override
    public List<T> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dataStore.get(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public T save(T entity) {

        try {

            Method getId = entity.getClass().getMethod("getId");
            Long id = (Long) getId.invoke(entity);

            if (id == null) {

                id = idGenerator.incrementAndGet();

                Method setId =
                        entity.getClass()
                                .getMethod("setId", Long.class);

                setId.invoke(entity, id);
            }

            dataStore.put((ID) id, entity);

            return entity;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(ID id) {
        dataStore.remove(id);
    }

    @Override
    public boolean existsById(ID id) {
        return dataStore.containsKey(id);
    }

    @Override
    public long count() {
        return dataStore.size();
    }
}