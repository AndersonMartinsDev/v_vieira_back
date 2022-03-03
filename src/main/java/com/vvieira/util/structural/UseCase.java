package com.vvieira.util.structural;

import org.mapstruct.factory.Mappers;

public interface UseCase<T> {
     T run();
     default <E> E convert(Class<E> clazz){
          return Mappers.getMapper(clazz);
     }
}
