package com.vvieira.app.caracteristica.casouso;

import com.vvieira.app.caracteristica.entidade.Caracteristica;
import com.vvieira.app.caracteristica.repositorio.CaracteristicaRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class CasoObterCaracteristica implements UseCase<Caracteristica> {

    @Autowired
    private CaracteristicaRepository repository;

    private Long id;

    @Override
    public Caracteristica run() {
        return repository.getById(id);
    }
}
