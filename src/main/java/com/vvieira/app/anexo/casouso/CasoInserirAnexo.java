package com.vvieira.app.anexo.casouso;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.anexo.repositorio.AnexoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Setter
public class CasoInserirAnexo implements UseCase<Long> {

    @Autowired
    private AnexoRepository repository;

    private MultipartFile file;

    @Override
    public Long run() throws IOException {
        Anexo anexo = new Anexo();
        anexo.setArquivo(file.getBytes());
        return repository.save(anexo).getId();
    }
}
