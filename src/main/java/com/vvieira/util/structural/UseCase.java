package com.vvieira.util.structural;

import com.vvieira.util.Paginacao;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Sort;

public interface UseCase<T> {

     T run();

     default <E> E convert(Class<E> clazz){
          return Mappers.getMapper(clazz);
     }

     default Paginacao paginacao(Integer pagina, Sort sort, Integer quantidadePagina){
          return new Paginacao(pagina,quantidadePagina,sort);
     }
}
