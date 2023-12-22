package com.appagendamento.appagendamento.model.service;

import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.domain.Instrutor;
import com.appagendamento.appagendamento.model.repositories.EstudanteRepository;
import com.appagendamento.appagendamento.model.repositories.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class InstrutorService {

    @Autowired
    private InstrutorRepository instrutorRepository;

    public void incluir(Instrutor instrutor){
        instrutorRepository.save(instrutor);
    }

    public Collection<Instrutor> obterLista(){
        return (Collection<Instrutor>) instrutorRepository.findAll();
    }

    public void excluir(Integer id) {
        instrutorRepository.deleteById(id);
    }
}
