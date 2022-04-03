package com.vvieira.app.produto.casouso;

import com.vvieira.app.produto.dto.ProdutoObterDto;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class CasoDeletarProduto implements UseCase<Void> {

    @Autowired
    private ProdutoRepository repository;

    private Long id;

    @Override
    public Void run() {
        repository.deleteById(id);
        return null;
    }
}
