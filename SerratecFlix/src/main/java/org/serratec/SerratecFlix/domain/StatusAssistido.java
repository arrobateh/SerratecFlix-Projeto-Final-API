package org.serratec.SerratecFlix.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Table;

@Table
public enum StatusAssistido {

    ASSISTIDO,
    PAUSADO,
    ABANDONADO,
    ASSISTINDO;

    @JsonCreator
    public static StatusAssistido from(String entrada) {
        for (StatusAssistido statusAssistido : values()) {
            if (statusAssistido.name().equalsIgnoreCase(entrada)) {
                return statusAssistido;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + entrada);
    }
}