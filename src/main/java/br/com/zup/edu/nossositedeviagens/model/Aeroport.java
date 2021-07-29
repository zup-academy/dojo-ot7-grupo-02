package br.com.zup.edu.nossositedeviagens.model;

import jdk.jfr.Enabled;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Aeroport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @NotNull
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public Pais getPais() {
        return pais;
    }

    @Deprecated
    public Aeroport(){}

    public Aeroport(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}
