package com.adrian.memberapi.repository;

import java.util.List;
import java.util.Optional;

public interface CustomJPARepository<T, ID> {

    Optional<T> find(ID id);
    List<T> findAll();
    T save(T entity);
    void delete(ID id);
}
