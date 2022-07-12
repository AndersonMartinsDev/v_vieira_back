package com.vvieira.app.produto.casouso.external;

import com.querydsl.core.BooleanBuilder;
import com.vvieira.app.produto.dto.ProdutoOnlineListarDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.QProduto;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.ListaPaginada;
import com.vvieira.util.Paginacao;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Setter
public class CasoExternalListarProduto implements UseCase<ListaPaginada<ProdutoOnlineListarDto>> {

    @Autowired
    private ProdutoRepository produtoRepository;

    private Integer pageIndex;

    @Override
    public ListaPaginada<ProdutoOnlineListarDto> run() {
        BooleanBuilder filtro = new BooleanBuilder();
        filtro.and(QProduto.produto.statusEnum.eq(StatusEnum.PUBLICADO));
        Page<Produto> page = produtoRepository.findAll(filtro,new Paginacao(pageIndex,10, Sort.unsorted()));
        List<ProdutoOnlineListarDto> lista = Lists.newArrayList();

        page.getContent().stream().forEach(produto ->lista.add(ProdutoOnlineListarDto.
                builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .imagem(produto.getImagens().stream().findFirst().get())
                .build()));
        return new ListaPaginada<>(lista,page.getTotalElements(),page.getNumber());
    }
}
