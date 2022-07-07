package com.vvieira.app.produto.repositorio;

import com.querydsl.core.types.Predicate;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.projections.PProdutoListar;
import com.vvieira.util.Paginacao;
import com.vvieira.util.structural.GenericRespository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends GenericRespository<Produto,Long> {}
