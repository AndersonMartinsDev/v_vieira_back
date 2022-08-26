package com.vvieira.util.structural;

import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public interface UseCase<T> {

     T run();

     default <E> E convert(Class<E> clazz){
          return Mappers.getMapper(clazz);
     }

     default PageRequest paginacao(Integer pagina,Integer quantidadePagina){
          return PageRequest.of(pagina,quantidadePagina, Sort.by(Sort.Direction.DESC,"id"));
     }
}
