package com.appagendamento.appagendamento.model.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Sessao {

    @Override
    public String toString() {
        return String.format("Tópicos (%s) - data (%s) - estudante (%s) - premium (%s) - instrutor (%s)",
                topicos, data_hora, estudante, premium, instrutor);
    }


    private List<Instrutor> instrutores;
    private LocalDateTime data_hora;
    private String topicos;
    private boolean premium;
    private Estudante estudante;
    private Instrutor instrutor;

}
