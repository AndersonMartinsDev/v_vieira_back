package com.vvieira.app.anexo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;

@Entity
@Getter
@Setter
@Table(name="anexo")
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="imagem")
    private File arquivo;
}
