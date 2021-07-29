package br.com.zup.edu.nossositedeviagens.model;

import br.com.zup.edu.nossositedeviagens.model.dto.CompanhiaResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    private LocalDateTime dataHoraCriacao = LocalDateTime.now();

    @ManyToOne
    @NotNull
    private Pais pais;

    @Deprecated
    public Companhia() {
    }

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public Pais getPais() {
        return this.pais;
    }
}
