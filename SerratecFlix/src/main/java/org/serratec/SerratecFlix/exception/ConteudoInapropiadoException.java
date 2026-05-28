package org.serratec.SerratecFlix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ConteudoInapropiadoException extends RuntimeException {
    public ConteudoInapropiadoException(String mensagem) {
        super(mensagem);
    }
}