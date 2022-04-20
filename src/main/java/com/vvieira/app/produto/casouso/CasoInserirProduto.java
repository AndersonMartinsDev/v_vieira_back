package com.vvieira.app.produto.casouso;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.produto.entidade.Caracteristica;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CasoInserirProduto implements UseCase<Void> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;
    private Set<Caracteristica> caracteristicas;
    private List<Anexo> imagens;

    @Override
    public Void run() {
        repository.save(convert(ProdutoMapper.class).toProduto(this));
        return null;
    }
}
