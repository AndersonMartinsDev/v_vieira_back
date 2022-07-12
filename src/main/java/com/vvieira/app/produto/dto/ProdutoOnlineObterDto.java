package com.vvieira.app.produto.dto;

import com.vvieira.app.anexo.entidade.Anexo;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class ProdutoOnlineObterDto {
    private Long id;
    private String nome;
    private String descricao;
    private Set<String> caracteristicas;
    private List<Anexo> imagens;

}
