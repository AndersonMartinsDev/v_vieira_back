package com.vvieira.app.anexo.controller;

import com.vvieira.app.anexo.casouso.CasoDeleteAnexo;
import com.vvieira.app.anexo.casouso.CasoInserirAnexo;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("api/anexo")
public class AnexoController {

    @Autowired
    private Facade facade;

    @PostMapping
    private Long inserir(@RequestPart MultipartFile file){
        CasoInserirAnexo casoInserirAnexo = new CasoInserirAnexo();
        casoInserirAnexo.setFile(file);
        return facade.run(casoInserirAnexo);
    }

    @DeleteMapping("{id}")
    private void delete(@PathVariable Long id){
        CasoDeleteAnexo caso = new CasoDeleteAnexo();
        caso.setId(id);
        facade.run(caso);
    }
}
