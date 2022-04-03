package com.vvieira.app.produto.dto;

import com.vvieira.app.caracteristica.entidade.Caracteristica;
import lombok.*;

import java.util.Set;

@Data
public class ProdutoObterDto {
    private String descricao;
    private Set<Caracteristica> caracteristicas;
}