package com.example.demo.estudante;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
public class Estudante {
    @Id
    @SequenceGenerator(
            name = "seq_estudante",
            sequenceName = "seq_estudante",
            allocationSize = 1 //Allocation size influencia no increment da sequence,
            //initialValue = 1 é o standard
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_estudante"
    )

    private Long id;
    private String nome;
    private String email;

    private LocalDate nascimento;


    @Transient //Deixa de criar uma coluna para a database
    private Integer idade;


    public Estudante() {
    }
    public Estudante(Long id, String nome, String email, Integer idade, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }

    public Estudante(String nome, String email, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getNascimento(){return nascimento;}

    public Integer getIdade() {
        return Period.between(this.nascimento, LocalDate.now()).getYears();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", nascimento='" + nascimento + '\'' +
                ", idade=" + idade +
                '}';
    }
}
