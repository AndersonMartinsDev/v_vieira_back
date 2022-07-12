package com.vvieira.app.produto.entidade.enums;

public enum CaracteristicaEnum {
    AR_CONDICIONADO("Ar Condicionado"),
    DIRECAO_HIDRAULICA("Direção Hidraulica"),
    MOTOR_1_4("Motor 1.4"),
    MOTOR_1_0("Motor 1.0"),
    MOTOR_1_8("Motor 1.8");

    private String descricao;

    CaracteristicaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return descricao;
    }
}
