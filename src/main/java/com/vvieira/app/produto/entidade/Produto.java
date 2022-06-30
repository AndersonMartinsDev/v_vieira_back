package com.vvieira.app.produto.entidade;

import com.querydsl.core.annotations.Config;
import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
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

    @ColumnDefault("Sem nome")
    @Column(name="nome",length = 200,nullable = false)
    private String nome;

    @Column(name="descricao",length = 2000,nullable = true)
    private String descricao;

    @Column(name="data_entrada")
    private LocalDate dataEntrada;

    @Column(name="data_saida")
    private LocalDate dataSaida;

    @ElementCollection(targetClass = CaracteristicaEnum.class)
    @JoinTable(name = "tb_caracteristicas", joinColumns =
    @JoinColumn(name = "caracteristica_id"))
    @Column(name = "caracteristicas", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Set<CaracteristicaEnum> caracteristicas;

    @Enumerated(EnumType.STRING)
    @ColumnDefault(value = "ADQUIRIDO")
    @Column(name="status")
    private StatusEnum statusEnum;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private List<Anexo> imagens;
}
