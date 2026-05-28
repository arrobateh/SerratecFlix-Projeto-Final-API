package org.serratec.SerratecFlix.validacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class ConteudoValidator
        implements ConstraintValidator<ConteudoApropriado, String> {

    private final List<String> palavrasProibidas =
            List.of("palavrao1", "palavrao2", "palavrao3");

    @Override
    public boolean isValid(String texto, ConstraintValidatorContext context) {
        if (texto == null) return true;
        return palavrasProibidas.stream()
                .noneMatch(p -> texto.toLowerCase().contains(p));
    }
}