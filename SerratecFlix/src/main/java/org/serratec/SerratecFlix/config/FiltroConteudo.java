package org.serratec.SerratecFlix.config;

import org.serratec.SerratecFlix.exception.ConteudoInapropiadoException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FiltroConteudo {

    private final List<String> palavrasProibidas = List.of(
            "palavrao1", "palavrao2", "palavrao3"
    );

    public void validar(String texto) {
        if (texto == null) return;
        for (String palavra : palavrasProibidas) {
            if (texto.toLowerCase().contains(palavra)) {
                throw new ConteudoInapropiadoException("Comentário contém linguagem inapropriada.");
            }
        }
    }
}
