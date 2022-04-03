package com.vvieira.app.caracteristica.casouso;

import com.querydsl.core.BooleanBuilder;
import com.vvieira.app.caracteristica.entidade.Caracteristica;
import static com.vvieira.util.QueryDslExpressionsUtil.expressionEq;

import static com.vvieira.app.caracteristica.entidade.QCaracteristica.caracteristica;
import com.vvieira.app.caracteristica.repositorio.CaracteristicaRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class CasoListarCaracteristicas implements UseCase<Iterable<Caracteristica>> {

    @Autowired
    private CaracteristicaRepository repository;

    private String descricao;

    @Override
    public Iterable<Caracteristica> run() {
        BooleanBuilder filtro = new BooleanBuilder();
        filtro.and(expressionEq(caracteristica.descricao,descricao));
        return repository.findAll(filtro);
    }
}
