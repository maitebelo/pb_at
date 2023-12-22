package com.appagendamento.appagendamento.service;

import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.domain.Sessao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessaoService {
    private Map<String, Sessao> mapa = new HashMap<String, Sessao>();

    public void incluir(Sessao sessao){
        mapa.put(sessao.getTopicos(), sessao);

    }

    public Collection<Sessao> obterLista(){
        return mapa.values();
    }
}
