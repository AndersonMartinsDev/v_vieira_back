package com.vvieira.app.anexo.entidade;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="anexo")
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name ="filename")
    private String filename;

    @Column(name="tipo_arquivo",length = 100)
    private String tipo;

    @Type(type="org.hibernate.type.BinaryType")
    @Column(name="arquivo")
    private byte[] arquivo;
}
