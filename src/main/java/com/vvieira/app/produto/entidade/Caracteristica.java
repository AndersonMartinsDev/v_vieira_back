package com.vvieira.app.produto.entidade;

import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "caracteristica")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="descricao")
    private CaracteristicaEnum descricao;
}
