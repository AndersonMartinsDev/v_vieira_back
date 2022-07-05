package com.vvieira.app.produto.repositorio;

import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.util.structural.GenericRespository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends GenericRespository<Produto,Long> {
}
