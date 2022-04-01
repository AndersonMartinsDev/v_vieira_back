package com.vvieira.util;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import java.util.Collection;
import java.util.Objects;

public class QueryDslExpressionsUtil {

    public static BooleanExpression expressionEq(StringPath ex, String valor){
        return valor.isEmpty() ? null: ex.eq(valor);
    }

    public static BooleanExpression expressionIn(NumberPath ex, Collection lista){
        return Objects.nonNull(lista) && lista.isEmpty() ? null: ex.in(lista);
    }

}
