package com.vvieira.app.produto.casouso;

import com.vvieira.app.produto.dto.ProdutoObterDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class CasoAtualizarStatusProduto implements UseCase<ProdutoObterDto> {

    @Autowired
    private ProdutoRepository repository;

    private Long id;
    private StatusEnum statusEnum;


    @Override
    public ProdutoObterDto run() {
        Produto produto = repository.getById(id);
        produto.setStatusEnum(statusEnum);
        return convert(ProdutoMapper.class).toProdutoObterDto(repository.save(produto));
    }
}
