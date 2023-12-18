package com.example.demo.estudante;

import com.example.demo.Exceptions.EmailExistsException;
import com.example.demo.Exceptions.IdDoesNotExist;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EstudanteService {
    private final EstudanteRepository estudanteRepository;
    @Autowired
    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }


    public List<Estudante> getEstudantes() {
        return estudanteRepository.findAll(); //O uso da interface de repository garante vários métodos, o método usado retorna uma lista
    }

    public void addNewStudent(Estudante estudante) {
        Optional<Estudante> estudanteByEmail =
                estudanteRepository.findEstudanteByEmail((estudante.getEmail())); //Optional é usado porque pode conter valor vazio ou presente. Se existir estudante o isPresent() retornará true
        if (estudanteByEmail.isPresent()) {
            throw new EmailExistsException("Email já existe");
        }
        //@Todo Inserir validação de e-mail mais complexa
        estudanteRepository.save(estudante);
    }

    public void deleteEstudante(Long estudanteId) {
        boolean idExiste = estudanteRepository.existsById(estudanteId);
        if (!idExiste){
            throw new IdDoesNotExist("N existe estudante com a id " + estudanteId);
        }
        estudanteRepository.deleteById(estudanteId);
    }

    @Transactional //Faz com que todas as operações executadas aqui serão revertidas caso não encontrem sucesso, funciona como o begin transaction e rollbacks do SQL
    public void updateExistingEstudante(Long id, String nome, String email) {
        Estudante estudante = estudanteRepository.findById(id)
                .orElseThrow(() -> new IdDoesNotExist("Nao existe estudante com tal id"));
        if (nome != null && !Objects.equals(estudante.getNome(), nome)){
            estudante.setNome(nome);

        }
        if (email != null && !Objects.equals(estudante.getEmail(), email)){
            Optional<Estudante> estudanteByEmail = estudanteRepository.findEstudanteByEmail(email);
            if (estudanteByEmail.isPresent()){
                throw new EmailExistsException("Email cadastrado já existe");
            }
            estudante.setEmail(email);
        }

    }
}
