package com.vvieira.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

@Component
public class Paginacao implements Pageable, Serializable {

    private Integer pagina = 0;
    private Integer totalItens = 10;
    private Sort sort;

    public Paginacao() {
    }

    public Paginacao(Integer pagina, Integer totalItens,Sort sort) {
        if (Objects.nonNull(totalItens) && totalItens < 1) {
            throw new IllegalArgumentException("Limit must not be less than one!");
        }
        if (Objects.nonNull(pagina) && pagina < 0) {
            throw new IllegalArgumentException("Offset index must not be less than zero!");
        }
        this.pagina = Objects.nonNull(pagina) ? pagina : 0;
        this.totalItens = Objects.nonNull(totalItens) ? totalItens : 10;
        this.sort = sort;
    }

    public Paginacao(Integer pageSize, Integer i) {
    }

    @Override
    public boolean isPaged() {
        return Pageable.super.isPaged();
    }

    @Override
    public boolean isUnpaged() {
        return Pageable.super.isUnpaged();
    }

    @Override
    public int getPageNumber() {
        return pagina;
    }//TODO: Talvez essa divisão funcione melhor com numeros do tipo double, depurar e fazer testes

    @Override
    public int getPageSize() {
        return totalItens;
    }

    @Override
    public long getOffset() {
        return pagina;
    }

    @Override
    public Sort getSort() {
        return Sort.by(Sort.Direction.DESC, "id");
    }

    @Override
    public Sort getSortOr(Sort sort) {
        return Pageable.super.getSortOr(sort);
    }

    @Override
    public Pageable next() {
        return new Paginacao(getPageSize(), (int) (getOffset() + getPageSize()));
    }

    public Pageable previous() {
        return hasPrevious() ?
                new Paginacao(getPageSize(), (int) (getOffset() - getPageSize())) : this;
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public Pageable first() {
        return new Paginacao(getPageSize(), 0);
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return Pageable.ofSize(pageNumber);
    }

    @Override
    public boolean hasPrevious() {
        return pagina > totalItens;
    }

    @Override
    public Optional<Pageable> toOptional() {
        return Pageable.super.toOptional();
    }
}
