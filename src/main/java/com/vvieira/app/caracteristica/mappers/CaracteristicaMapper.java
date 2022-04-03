package com.vvieira.app.caracteristica.mappers;

import com.vvieira.app.caracteristica.casouso.CasoInserirCaracteristica;
import com.vvieira.app.caracteristica.entidade.Caracteristica;
import org.mapstruct.Mapper;

@Mapper
public interface CaracteristicaMapper {
    Caracteristica toCaracteristica(CasoInserirCaracteristica entity);
}
