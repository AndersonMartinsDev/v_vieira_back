package com.vvieira.util;

import com.querydsl.core.types.dsl.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

public class QueryDslExpressionsUtil {


    public static BooleanExpression expressionDataEquals(DatePath ex, LocalDate valor){
        if(Objects.isNull(valor) || valor.equals("null")){
            return null;
        }
        return ex.eq(valor);
    }


    public static BooleanExpression expressionEq(StringPath ex, String valor){
        if(Objects.isNull(valor) || valor.equals("null")){
            return null;
        }
        return valor.isEmpty() ? null: ex.eq(valor);
    }

    public static BooleanExpression expressionLike(StringPath ex, String valor){
        if(Objects.isNull(valor) || valor.equals("null")){
            return null;
        }
        return valor.isEmpty() ? null: ex.like(valor);
    }

    public static BooleanExpression expressionIn(SetPath ex, Collection lista){
        if(Objects.isNull(lista)){
            return null;
        }
        return lista.isEmpty() ? null : ex.any().in(lista);
    }
}
