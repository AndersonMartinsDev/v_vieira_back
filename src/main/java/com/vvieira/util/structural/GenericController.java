package com.vvieira.util.structural;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface GenericController<T,E> {
    T inserir(E caso);
    T obter(Long id);
    void delete(Long id);
}
