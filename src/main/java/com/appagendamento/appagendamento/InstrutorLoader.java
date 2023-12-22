package com.appagendamento.appagendamento;
import com.appagendamento.appagendamento.model.domain.Instrutor;
import com.appagendamento.appagendamento.model.service.InstrutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;


@Order(2)
@Component
public class InstrutorLoader  implements ApplicationRunner {

    @Autowired
    private InstrutorService instrutorService;
     public void run (ApplicationArguments args) throws Exception{

        FileReader file = new FileReader("files/instrutores.txt");
        BufferedReader leitura =  new BufferedReader((file));

        String linha = leitura.readLine();

        String[] campos = null;

        while(linha != null){
            campos = linha.split(";");
            Instrutor instrutor = new Instrutor();
            instrutor.setNome(campos[0]);
            instrutor.setEmail(campos[1]);
            instrutor.setCpf(campos[2]);

            instrutorService.incluir(instrutor);
            linha = leitura.readLine();
        }

        for(Instrutor instrutor: instrutorService.obterLista()){
            System.out.println("[INSTRUTOR] " + instrutor);
        }

        leitura.close();
    }
}
