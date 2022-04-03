package com.vvieira.app.caracteristica.entidade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="caracteristica")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="descricao",length = 250)
    private String descricao;
}