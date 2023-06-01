package com.example.mvcdepartament.persistence;

import java.util.List;

public interface BaseDAO<T, K> {

    void save(T item);
    void update(T item);
    void delete(T item);
    void deleteByKey(K key);
    List<T> findAll();
    void findOne(K key);
    void loadNestedEntitiesHook(List<T> entities);
}
