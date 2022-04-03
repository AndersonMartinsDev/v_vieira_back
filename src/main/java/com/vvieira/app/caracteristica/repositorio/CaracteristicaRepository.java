package com.vvieira.app.caracteristica.repositorio;

import com.vvieira.app.caracteristica.entidade.Caracteristica;
import com.vvieira.util.structural.GenericRespository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristicaRepository extends GenericRespository<Caracteristica,Long> {
}
