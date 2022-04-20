package com.vvieira.app.produto.casouso.dominio;

import com.vvieira.app.produto.entidade.enums.CaracteristicaEnum;
import com.vvieira.app.produto.entidade.enums.StatusEnum;
import com.vvieira.util.structural.UseCase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CasoDominioStatusEnum implements UseCase<List<String>> {
    @Override
    public List<String> run() {
        return Arrays.stream(StatusEnum.values()).map(StatusEnum::name).collect(Collectors.toList());
    }
}
