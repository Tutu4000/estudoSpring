package com.example.demo.estudante;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void novoEstudante(@RequestBody Estudante estudante){ //Pegar do request body e mapear into estudante
        estudanteService.addNewStudent(estudante);
    }

    //DELETE http://localhost:8081/api/v1/estudante/1
    @DeleteMapping(path = "{estudanteId}") // Path variable faz com que o path da URL seja armazenado em uma variável
    public void deleteEstudante(@PathVariable("estudanteId") Long estudanteId){//(Data Binding) Mapeamento do parametro da requisição para parametros de método no controlador
        estudanteService.deleteEstudante(estudanteId);
    }

    //PUT http://localhost:8081/api/v1/estudante/1?nome=Carlos
    @PutMapping(path = "{estudanteId}")
    public void updateEstudante(
            @PathVariable("estudanteId") Long estudanteId,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email
    ){
        estudanteService.updateExistingEstudante(estudanteId,nome,email);
    }
}
