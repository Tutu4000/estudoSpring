package com.example.demo.estudante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/estudante")//Em vez do diretório ser o root do localhost ele será o diretório definido aqui
public class EstudanteController {
    private final EstudanteService estudanteService; //Referencia a business layer
    @Autowired
    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService =  estudanteService;
    }

    @GetMapping
    public List<Estudante> getEstudantes() {
        return estudanteService.getEstudantes();
    }
}
