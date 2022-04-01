package com.vvieira.app.produto.mappers;

import com.vvieira.app.produto.casouso.CasoInserirProduto;
import com.vvieira.app.produto.dto.ProdutoObterDto;
import com.vvieira.app.produto.entidade.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface ProdutoMapper {
    ProdutoObterDto toProdutoObeterDto(Produto produto);
    Produto toProduto(CasoInserirProduto caso);
}
