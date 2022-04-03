package com.vvieira.app.anexo.casouso;

import com.vvieira.app.anexo.repositorio.AnexoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Setter
public class CasoDeleteAnexo implements UseCase<Void> {

    @Autowired
    private AnexoRepository repository;

    private Long id;

    @Override
    public Void run() {
        repository.deleteById(id);
        return null;
    }
}
