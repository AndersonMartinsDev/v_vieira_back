package com.vvieira.util;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;

import java.util.Collection;
import java.util.Objects;

public class QueryDslExpressionsUtil {

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
