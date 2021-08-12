package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "aeroportoOrigem")
    private List<Rout> rotasOrigem = new ArrayList<>();

    @OneToMany(mappedBy = "aeroportoDestino")
    private List<Rout> rotasDestino = new ArrayList<>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aeroport aeroport = (Aeroport) o;
        return nome.equals(aeroport.nome) && pais.equals(aeroport.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pais);
    }
}
