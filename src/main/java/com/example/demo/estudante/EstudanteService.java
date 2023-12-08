package com.example.demo.estudante;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    public List<Estudante> getEstudantes() {
        return List.of(
                new Estudante(
                        1L, "Arthur", "arthur@gmail.com", 19
                )
        );
    }

}
