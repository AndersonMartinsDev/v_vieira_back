package com.vvieira.app.produto.casouso.external;

import com.vvieira.app.produto.dto.ProdutoOnlineObterDto;
import com.vvieira.app.produto.entidade.Produto;
import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.repositorio.ProdutoRepository;
import com.vvieira.exceptions.ManagementException;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
public class CasoExternalObterProduto implements UseCase<ProdutoOnlineObterDto> {


    @Autowired
    private ProdutoRepository repository;

    private Long id;

    @Override
    public ProdutoOnlineObterDto run() {
        Optional<Produto> optProduto = repository.findById(id);
        if (!optProduto.isPresent()) {
            throw new ManagementException("Produto não encontrado!");
        }
        Produto produto = optProduto.get();
        Set<String> caracteristicas = produto.getCaracteristicas()
                                                .stream()
                                                .map(CaracteristicaEnum::getNome)
                                                .collect(Collectors.toSet());
        return ProdutoOnlineObterDto.builder()
                .id(produto.getId())
                .descricao(produto.getDescricao())
                .nome(produto.getNome())
                .caracteristicas(caracteristicas)
                .imagens(produto.getImagens())
                .build();
    }
}
