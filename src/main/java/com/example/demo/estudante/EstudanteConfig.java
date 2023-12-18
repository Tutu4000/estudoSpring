package com.example.demo.estudante;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EstudanteConfig { //Inserções padrão para teste

    @Bean
    CommandLineRunner commandLineRunner(EstudanteRepository repository){
        return args -> {
                    Estudante Arthur = new Estudante(
                            "Arthur", "arthur@gmail.com", LocalDate.of(2004, Month.APRIL, 6)
                    );

            Estudante Artyom = new Estudante(
                    "Artyom", "alex@gmail.com", LocalDate.of(2006, Month.DECEMBER, 12)
            );
            repository.saveAll(List.of(Arthur, Artyom)); //Chama um "insert to" no sql
        };
    }
}
