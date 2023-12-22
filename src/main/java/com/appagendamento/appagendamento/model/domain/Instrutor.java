package com.appagendamento.appagendamento.model.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Instrutor {

    @Override
    public String toString() {
        return String.format("Nome (%s) -  email (%s) - cpf (%s)",  nome, email, cpf);
    }

    private String nome;
    private String email;
    private String cpf;
}
