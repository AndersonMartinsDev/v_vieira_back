package com.vvieira.app.anexo.entidade;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.web.multipart.MultipartFile;

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

    @Type(type="org.hibernate.type.BinaryType")
    @Column(name="arquivo")
    private byte[] arquivo;
}
