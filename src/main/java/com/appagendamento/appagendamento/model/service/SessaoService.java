package com.appagendamento.appagendamento.model.service;

import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.domain.Sessao;
import com.appagendamento.appagendamento.model.repositories.EstudanteRepository;
import com.appagendamento.appagendamento.model.repositories.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;

    public void incluir(Sessao sessao){
        sessaoRepository.save(sessao);
    }

    public Collection<Sessao> obterLista(){
        return (Collection<Sessao>) sessaoRepository.findAll();
    }

    public void excluir(Integer id) {
        sessaoRepository.deleteById(id);
    }
}
