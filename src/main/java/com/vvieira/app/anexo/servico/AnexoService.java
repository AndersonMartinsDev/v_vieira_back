package com.vvieira.app.anexo.servico;

import com.vvieira.app.anexo.repositorio.AnexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnexoService {

    @Autowired
    private AnexoRepository repository;

    @Transactional
    public void deleteAllProdutoIdNull(){
        repository.deleteAllProdutoIdNull();
    }
}
