package br.gov.sp.fatec.gedam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.gov.sp.fatec.gedam.tool.Texto;

@ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
public class DataInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String M_STRING = Texto.Trad("Data inválida: \"");

	public DataInvalidaException() {
        super();
    }

    public DataInvalidaException(String message){
        super(M_STRING + message + "\"");
    }

    public DataInvalidaException(Throwable cause){
        super(cause);
    }

    public DataInvalidaException(String message, Throwable cause){
        super(M_STRING + message + "\"", cause);
    }
	
}
