package com.vvieira.app.produto.dto;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
public class ProdutoObterDto {
    private Long id;
    private String nome;
    private StatusEnum status;
    private String descricao;
    private Set<CaracteristicaEnum> caracteristicas;
    private List<Anexo> imagens;
}
