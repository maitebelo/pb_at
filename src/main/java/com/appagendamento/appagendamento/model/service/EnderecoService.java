package com.appagendamento.appagendamento.model.service;

import com.appagendamento.appagendamento.clients.IEnderecoClient;
import com.appagendamento.appagendamento.model.domain.Endereco;
import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoClient enderecoClient;

    public Endereco buscarCep(String cep) {
        return enderecoClient.buscarCep(cep);
    }
}