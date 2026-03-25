package br.com.rogerio.api.pessoaendereco.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }
}
