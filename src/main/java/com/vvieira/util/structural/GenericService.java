package com.vvieira.util.structural;

import java.util.List;

public interface GenericService <T> {
    List<T> list();
    void save(T entity);
    void delete(T entity);
}
