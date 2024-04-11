package one.digitalinnovation.gof.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException (String mensagem) {
        super(mensagem);
    }
}
