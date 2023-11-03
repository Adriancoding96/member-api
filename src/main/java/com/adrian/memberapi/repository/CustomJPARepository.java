package com.adrian.memberapi.repository;

import java.util.List;

public interface CustomJPARepository<T, ID> {

    T find(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(ID id);
}
