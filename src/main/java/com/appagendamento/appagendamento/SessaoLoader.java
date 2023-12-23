package com.appagendamento.appagendamento;

import com.appagendamento.appagendamento.model.domain.Endereco;
import com.appagendamento.appagendamento.model.domain.Estudante;
import com.appagendamento.appagendamento.model.domain.Instrutor;
import com.appagendamento.appagendamento.model.domain.Sessao;
import com.appagendamento.appagendamento.model.service.EstudanteService;
import com.appagendamento.appagendamento.model.service.InstrutorService;
import com.appagendamento.appagendamento.model.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

@Order(3)
@Component
public class SessaoLoader implements ApplicationRunner {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private EstudanteService estudanteService;

    @Autowired
    private InstrutorService instrutorService;

    public void run(ApplicationArguments args) throws Exception {

        LocalDateTime dataHoraAtual = LocalDateTime.now();

        FileReader file = new FileReader("files/sessoes.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();

        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

                Endereco endereco = new Endereco();
                endereco.setCep(campos[5]);



                Estudante estudante = new Estudante();
                estudante.setNome(campos[2]);
                estudante.setEmail(campos[3]);
                estudante.setCpf(campos[4]); 

                estudante.setEndereco(endereco);
                estudanteService.incluir(estudante);

                Instrutor instrutor = new Instrutor();
                instrutor.setNome(campos[6]);
                instrutor.setEmail(campos[7]);
                instrutor.setCpf(campos[7]);
                instrutorService.incluir(instrutor);

                Sessao sessao = new Sessao();
                sessao.setTopicos(campos[0]);
                sessao.setPremium(Boolean.valueOf(campos[1]));
                sessao.setData_hora(dataHoraAtual);

                sessao.setEstudante(estudante);
                sessao.setInstrutor(instrutor);
                sessaoService.incluir(sessao);


            linha = leitura.readLine();
        }

        for(Sessao sessao: sessaoService.obterLista()){
            System.out.println("[SESSAO] " + sessao);
        }
        leitura.close();
    }
}
