package com.appagendamento.appagendamento.service;

import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.domain.Instrutor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class InstrutorService {
    private Map<String, Instrutor> mapa = new HashMap<String, Instrutor>();

    public void incluir(Instrutor instrutor){
        mapa.put(instrutor.getNome(), instrutor);

    }

    public Collection<Instrutor> obterLista(){
        return mapa.values();
    }
}
