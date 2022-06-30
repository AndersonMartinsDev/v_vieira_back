package com.vvieira.app.produto.casouso;

import com.vvieira.app.produto.entidade.Caracteristica;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Getter
@Setter
public class CasoAtualizarProduto implements UseCase<Produto> {

    @Autowired
    private ProdutoRepository repository;

    private Long id;
    private String nome;
    private String descricao;
    private Set<CaracteristicaEnum> caracteristicas;

    @Override
    public Produto run() {
        Produto produto = repository.getById(id);
        convert(ProdutoMapper.class).toAtualizarProduto(this,produto);
        return repository.save(produto);
    }
}
