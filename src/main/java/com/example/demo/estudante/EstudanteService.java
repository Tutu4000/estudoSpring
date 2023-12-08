package com.example.demo.estudante;

import java.util.List;

public class EstudanteService {

    public List<Estudante> getEstudantes() {
        return List.of(
                new Estudante(
                        1L, "Arthur", "arthur@gmail.com", 19
                )
        );
    }

}
