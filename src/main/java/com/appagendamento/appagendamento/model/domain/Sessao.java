package com.appagendamento.appagendamento.model.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "TSessao")
public class Sessao {

    @Override
    public String toString() {
        return String.format("Id (%d) - tópicos (%s) - data (%s)  - premium (%s) - instrutor (%s) - estudante (%s)", id,
                topicos, data_hora, premium, instrutor, estudante );
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime data_hora;
    private String topicos;
    private boolean premium;

    @ManyToOne
    @JoinColumn(name = "estudante_id")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

}
