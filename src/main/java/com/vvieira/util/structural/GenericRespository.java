package com.vvieira.util.structural;

import com.querydsl.core.types.Predicate;
import com.vvieira.util.ListaPaginada;
import com.vvieira.util.Paginacao;
import liquibase.pro.packaged.E;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface GenericRespository<T, ID> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {}
