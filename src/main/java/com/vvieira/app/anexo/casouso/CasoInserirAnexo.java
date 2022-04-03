package com.vvieira.app.anexo.casouso;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.anexo.repositorio.AnexoRepository;
import com.vvieira.util.structural.UseCase;
import org.springframework.beans.factory.annotation.Autowired;


public class CasoInserirAnexo implements UseCase<Long> {

    @Autowired
    private AnexoRepository repository;

    @Override
    public Long run() {
        Anexo anexo = repository.save(null);
        return anexo.getId();
    }
}
