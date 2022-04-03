package com.vvieira.app.caracteristica.controller;

import com.vvieira.app.caracteristica.casouso.CasoDeleteCaracteristica;
import com.vvieira.app.caracteristica.casouso.CasoInserirCaracteristica;
import com.vvieira.app.caracteristica.casouso.CasoListarCaracteristicas;
import com.vvieira.app.caracteristica.casouso.CasoObterCaracteristica;
import com.vvieira.app.produto.casouso.CasoInserirProduto;
import com.vvieira.app.caracteristica.entidade.Caracteristica;
import com.vvieira.util.structural.Facade;
import com.vvieira.util.structural.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/caracteristica")
public class CaracteristicasController implements GenericController<Caracteristica, CasoInserirCaracteristica> {

    @Autowired
    private Facade facade;

    @Override
    @PostMapping
    public Caracteristica inserir(@RequestBody CasoInserirCaracteristica caso) {
        return facade.run(caso);
    }

    @Override
    @GetMapping("{id}")
    public Caracteristica obter(@PathVariable Long id){
        CasoObterCaracteristica caso = new CasoObterCaracteristica();
        caso.setId(id);
        return facade.run(caso);
    };

    @Override
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        CasoDeleteCaracteristica caso = new CasoDeleteCaracteristica();
        caso.setId(id);
        facade.run(caso);
    }

    @GetMapping
    public Iterable<Caracteristica> listar(CasoListarCaracteristicas caso) {
        return facade.run(caso);
    }
}
