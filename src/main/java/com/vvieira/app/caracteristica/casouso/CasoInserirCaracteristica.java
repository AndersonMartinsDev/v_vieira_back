package com.vvieira.app.caracteristica.casouso;

import com.vvieira.app.caracteristica.mappers.CaracteristicaMapper;
import com.vvieira.app.caracteristica.repositorio.CaracteristicaRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
@Getter
public class CasoInserirCaracteristica implements UseCase<Void> {

    @Autowired
    private CaracteristicaRepository repository;

    private String descricao;

    @Override
    public Void run() {
        repository.save(convert(CaracteristicaMapper.class).toCaracteristica(this));
        return null;
    }
}