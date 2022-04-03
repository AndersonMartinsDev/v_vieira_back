package com.vvieira.app.produto.entidade;

import com.querydsl.core.annotations.Config;
import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.caracteristica.entidade.Caracteristica;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="produto")
@Config(listAccessors = true)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="descricao",length = 2000)
    private String descricao;

    @OneToMany
    @JoinColumn(name="produto_id")
    private Set<Caracteristica> caracteristicas;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private List<Anexo> imagens;
}
