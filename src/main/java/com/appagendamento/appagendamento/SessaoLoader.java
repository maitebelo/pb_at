package com.appagendamento.appagendamento;

import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.domain.Instrutor;
import com.appagendamento.appagendamento.model.domain.Sessao;
import com.appagendamento.appagendamento.service.EstudanteService;
import com.appagendamento.appagendamento.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.Permission;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Order(3)
@Component
public class SessaoLoader implements ApplicationRunner {

    @Autowired
    private SessaoService sessaoService;

    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/sessoes.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos;

        while (linha != null) {
            campos = linha.split(";");

            Sessao sessao = null;
            if (campos.length >= 5) {
                Estudante estudante = new Estudante();
                estudante.setNome(campos[2]);
                estudante.setEmail(campos[3]);
                estudante.setCpf(campos[4]);

                Instrutor instrutor = new Instrutor();
                instrutor.setNome(campos[5]);
                instrutor.setEmail(campos[6]);
                instrutor.setCpf(campos[7]);

                sessao = new Sessao();
                sessao.setTopicos(campos[0]);
                sessao.setPremium(Boolean.valueOf(campos[1]));
                sessao.setData_hora(LocalDateTime.now());
                sessao.setEstudante(estudante);
                sessao.setInstrutor(instrutor);

                sessaoService.incluir(sessao);
            } else {
                System.err.println("Erro: " + linha);
            }


            linha = leitura.readLine();
        }
        for(Sessao sessao: sessaoService.obterLista()){
            System.out.println("[SESSAO] " + sessao);
        }
        leitura.close();
    }
}
