package com.vvieira.app.produto.dto;

import com.vvieira.app.produto.entidade.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProdutoListarDto {
    private Long id;
    private String nome;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private StatusEnum statusEnum;
}
