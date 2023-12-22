package com.appagendamento.appagendamento;

import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Order(1)
@Component
public class EstudanteLoader implements ApplicationRunner {

    @Autowired
    private EstudanteService estudanteService;

    public void run (ApplicationArguments args) throws Exception{

        FileReader file = new FileReader("files/estudantes.txt");
        BufferedReader leitura =  new BufferedReader((file));

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");
            Estudante estudante = new Estudante();
            estudante.setNome(campos[0]);
            estudante.setEmail(campos[1]);
            estudante.setCpf(campos[2]);


            estudanteService.incluir(estudante);
            linha = leitura.readLine();
        }

        for(Estudante estudante : estudanteService.obterLista()){
            System.out.println("[ESTUDANTE] " + estudante);
        }

        leitura.close();
    }
}
