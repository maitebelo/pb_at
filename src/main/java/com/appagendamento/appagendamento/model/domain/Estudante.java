package com.appagendamento.appagendamento.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estudante {

    public Estudante() {
    }

    public Estudante(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;

    }

    @Override
    public String toString() {
        return String.format("Nome (%s) -  email (%s) - cpf (%s)",  nome, email, cpf);
    }

    private String nome;
    private String email;
    private String cpf;
}

