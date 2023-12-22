package com.appagendamento.appagendamento.model.controller;


import com.appagendamento.appagendamento.model.domain.Sessao;
import com.appagendamento.appagendamento.model.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessao")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @GetMapping(value = "/listar")
    public List<Sessao> obterLista(){
        return (List<Sessao>) sessaoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Sessao sessao) {
        sessaoService.incluir(sessao);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        sessaoService.excluir(id);
    }

}
