package com.vvieira.app.produto.dto;

import com.vvieira.app.produto.entidade.Caracteristica;
import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import lombok.*;

import javax.persistence.Enumerated;
import java.util.Set;

@Data
public class ProdutoObterDto {
    private Long id;
    private String nome;
    private StatusEnum status;
    private String descricao;
    private Set<CaracteristicaEnum> caracteristicas;
}
