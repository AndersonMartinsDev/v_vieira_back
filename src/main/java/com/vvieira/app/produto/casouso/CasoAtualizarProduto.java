package com.vvieira.app.produto.casouso;

import com.vvieira.app.produto.entidade.Caracteristica;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Getter
@Setter
public class CasoAtualizarProduto implements UseCase<Void> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;
    private Set<Caracteristica> caracteristicas;

    @Override
    public Void run() {
        return null;
    }
}
