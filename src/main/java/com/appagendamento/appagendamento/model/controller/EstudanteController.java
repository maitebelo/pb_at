package com.appagendamento.appagendamento.model.controller;


import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudante")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping(value = "/listar")
    public List<Estudante> obterLista(){
        return (List<Estudante>) estudanteService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Estudante estudante) {
        estudanteService.incluir(estudante);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        estudanteService.excluir(id);
    }

}
