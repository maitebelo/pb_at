package com.appagendamento.appagendamento.model.service;

import com.appagendamento.appagendamento.model.domain.Endereco;
import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private EnderecoService enderecoService;

    public void incluir(Estudante estudante){
        if (estudante.getEndereco() != null) {
            String cep = estudante.getEndereco().getCep();
            Endereco endereco = enderecoService.buscarCep(cep);
            estudante.setEndereco(endereco);
            estudanteRepository.save(estudante);
        }
    }

    public Collection<Estudante> obterLista(){
        return (Collection<Estudante>) estudanteRepository.findAll();
    }

    public void excluir(Integer id) {
        estudanteRepository.deleteById(id);
    }
}
