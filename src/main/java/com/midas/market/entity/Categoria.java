package com.midas.market.entity;

import java.util.Arrays;

public enum Categoria {

    TECNOLOGIA,ELECTRODOMESTICOS,HOGAR;

    public static boolean isValidCategoria(String value) {
        return Arrays.asList(Categoria.values()).stream()
                .anyMatch(c -> c.name().equalsIgnoreCase(value));
    }
}
