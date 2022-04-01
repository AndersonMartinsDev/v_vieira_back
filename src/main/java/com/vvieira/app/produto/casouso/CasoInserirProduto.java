package com.vvieira.app.produto.casouso;

import com.vvieira.app.produto.entidade.Caracteristica;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class CasoInserirProduto implements UseCase<Void> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;
    private Set<Caracteristica> caracteristicas;

    @Override
    public Void run() {
        repository.save(convert(ProdutoMapper.class).toProduto(this));
        return null;
    }
}
