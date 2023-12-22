package com.appagendamento.appagendamento.controllers;

import com.appagendamento.appagendamento.domain.session.RequestSession;
import com.appagendamento.appagendamento.domain.session.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendarSessao")
public class SessionController {
    @Autowired
    private SessionRepository repository;
    @GetMapping
    public ResponseEntity getAgendamentos(){
        var allSessions = repository.findAll();
        return ResponseEntity.ok(allSessions);
    }

    @PostMapping
    public ResponseEntity addSession(@RequestBody @Validated RequestSession data){
        System.out.println(data);
        return ResponseEntity.ok().build();
    }
}
