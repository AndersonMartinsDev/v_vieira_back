package com.vvieira.app.anexo.repositorio;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.util.structural.GenericRespository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends GenericRespository<Anexo,Long> {

    @Modifying
    @Query(value = "delete from anexo where produto_id is null",nativeQuery = true)
    void deleteAllProdutoIdNull();
}
