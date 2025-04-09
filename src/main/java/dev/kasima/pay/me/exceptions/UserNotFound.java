package dev.kasima.pay.me.exceptions;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String mensagem) {
        super(mensagem);
    }
}
