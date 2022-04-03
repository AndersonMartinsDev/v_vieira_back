package com.vvieira.app.anexo.controller;

import com.vvieira.app.anexo.casouso.CasoDeleteAnexo;
import com.vvieira.app.anexo.casouso.CasoInserirAnexo;
import com.vvieira.util.structural.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/anexo")
public class AnexoController {

    @Autowired
    private Facade facade;

    @PostMapping
    private Long inserir(@RequestBody CasoInserirAnexo caso){
        return facade.run(caso);
    }

    @DeleteMapping("{id}")
    private void delete(Long id){
        CasoDeleteAnexo caso = new CasoDeleteAnexo();
        caso.setId(id);
        facade.run(caso);
    }
}
