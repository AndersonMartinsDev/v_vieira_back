package com.vvieira.app.anexo.repositorio;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.util.structural.GenericRespository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends GenericRespository<Anexo,Long> {
}
