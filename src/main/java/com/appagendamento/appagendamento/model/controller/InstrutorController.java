package com.appagendamento.appagendamento.model.controller;


import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.domain.Instrutor;
import com.appagendamento.appagendamento.model.service.EstudanteService;
import com.appagendamento.appagendamento.model.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorService instrutorService;

    @GetMapping(value = "/listar")
    public List<Instrutor> obterLista(){
        return (List<Instrutor>) instrutorService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public void incluir(@RequestBody Instrutor instrutor) {
        instrutorService.incluir(instrutor);
    }

    @DeleteMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        instrutorService.excluir(id);
    }

}
