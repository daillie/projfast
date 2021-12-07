package com.company.model.table;

import java.util.List;

public interface DataAccessObject<T> {
    List<T> getAll();
    T getById(Long id);
    boolean insert(T t);
}
