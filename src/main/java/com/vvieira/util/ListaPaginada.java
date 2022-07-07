package com.vvieira.util;

import lombok.Getter;

import java.util.Collection;
import java.util.List;

@Getter
public class ListaPaginada<T> {
    private Collection<T> elementos;
    private Long total;
    private Integer pagina;

    public ListaPaginada(){}

    public ListaPaginada(Collection<T> lista, Long total, Integer pagina){
        this.elementos = lista;
        this.total = total;
        this.pagina = pagina;
    }

}
