package com.appagendamento.appagendamento.service;

import com.appagendamento.appagendamento.model.domain.Estudante;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EstudanteService {
    private Map<String, Estudante> mapa = new HashMap<String, Estudante>();

    public void incluir(Estudante estudante){
        mapa.put(estudante.getNome(), estudante);

    }

    public Collection<Estudante> obterLista(){
        return mapa.values();
    }
}
