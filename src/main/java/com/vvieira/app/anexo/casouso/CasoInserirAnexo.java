package com.vvieira.app.anexo.casouso;

import com.vvieira.app.anexo.entidade.Anexo;
import com.vvieira.app.anexo.repositorio.AnexoRepository;
import com.vvieira.util.structural.UseCase;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;


@Setter
public class CasoInserirAnexo implements UseCase<Long> {

    @Autowired
    private AnexoRepository repository;

    private MultipartFile file;

    @SneakyThrows
    @Override
    public Long run() {
        Anexo anexo = new Anexo();
        anexo.setFilename(file.getOriginalFilename());
        anexo.setTipo(file.getContentType());
        anexo.setArquivo(file.getBytes());
        return repository.save(anexo).getId();
    }
}
