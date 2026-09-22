package com.senai.cadastro.application.exception;

public class UsuarioDuplicadoException extends RuntimeException {
    public UsuarioDuplicadoException(String atributo) {
        super("Já existe um usuário cadastrado com este " + atributo);
    }
}