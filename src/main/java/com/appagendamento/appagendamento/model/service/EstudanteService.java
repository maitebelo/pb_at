package com.appagendamento.appagendamento.model.service;

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

    public void incluir(Estudante estudante){
        estudanteRepository.save(estudante);
    }

    public Collection<Estudante> obterLista(){
        return (Collection<Estudante>) estudanteRepository.findAll();
    }

    public void excluir(Integer id) {
        estudanteRepository.deleteById(id);
    }
}
