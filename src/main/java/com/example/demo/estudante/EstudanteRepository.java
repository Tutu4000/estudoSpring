package com.example.demo.estudante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository< Estudante, Long > // Jpa repository necessita de especificação do <Tipo, ID>
{
    //@Query("SELECT ...") Posso especificar a query ou usar ferramentas prontas como no exemplo abaixo
    Optional<Estudante> findEstudanteByEmail(String email);


}
