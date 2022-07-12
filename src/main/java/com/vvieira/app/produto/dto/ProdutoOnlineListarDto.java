package com.vvieira.app.produto.dto;

import com.vvieira.app.anexo.entidade.Anexo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProdutoOnlineListarDto {
    private Long id;
    private String nome;
    private Anexo imagem;
}
