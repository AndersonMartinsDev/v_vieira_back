package com.vvieira.util.structural;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface GenericRespository<T,ID> extends JpaRepository<T,ID> {
    Page<T> findAll(Pageable pageable);
    List<T> findAll(Sort sort);
}
