package com.appagendamento.appagendamento.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "TEstudante")
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
        return String.format("Id (%d) - Nome (%s) - email (%s) - cpf (%s), - cep (%s)", id, nome, email, cpf, endereco.getCep());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String cpf;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL)
    private List<Sessao> sessoes;


}

