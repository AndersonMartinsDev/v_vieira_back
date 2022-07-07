package com.vvieira.app.produto.mappers;

import com.vvieira.app.produto.casouso.CasoAtualizarProduto;
import com.vvieira.app.produto.casouso.CasoInserirProduto;
import com.vvieira.app.produto.dto.ProdutoListarDto;
import com.vvieira.app.produto.dto.ProdutoObterDto;
import com.vvieira.app.produto.entidade.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper
public interface ProdutoMapper {
    List<ProdutoListarDto> toListProdutoListarDto(List<Produto> lista);
    ProdutoObterDto toProdutoObterDto(Produto produto);
    Produto toProduto(CasoInserirProduto caso);
    @Mapping(source = "id", target = "id")
    Produto toAtualizarProduto(CasoAtualizarProduto caso, @MappingTarget Produto produto);
}
