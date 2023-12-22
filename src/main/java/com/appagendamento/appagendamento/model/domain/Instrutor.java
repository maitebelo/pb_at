package com.appagendamento.appagendamento.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TInstrutor")
public class Instrutor {

    @Override
    public String toString() {
        return String.format("ID (%d) - Nome (%s) -  email (%s) - cpf (%s)", id,  nome, email, cpf);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "instrutor")
    private List<Sessao> sessoes;
}
