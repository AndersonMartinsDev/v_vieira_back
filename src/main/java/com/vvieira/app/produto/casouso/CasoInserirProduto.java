package com.vvieira.app.produto.casouso;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import com.vvieira.app.produto.mappers.ProdutoMapper;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CasoInserirProduto implements UseCase<Produto> {

    @Autowired
    private ProdutoRepository repository;

    private String nome;
    private String descricao;
    private Set<CaracteristicaEnum> caracteristicas;
    private List<Anexo> imagens;

    @Override
    public Produto run() {
        Produto produto = convert(ProdutoMapper.class).toProduto(this);
        produto.setDataEntrada(LocalDate.now());
        produto.setStatusEnum(StatusEnum.ADQUIRIDO);
        return repository.save(produto);
    }
}
