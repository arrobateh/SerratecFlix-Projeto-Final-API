package org.serratec.SerratecFlix.validacao;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ConteudoValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConteudoApropriado {
    String message() default "Comentário contém linguagem inapropriada.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}