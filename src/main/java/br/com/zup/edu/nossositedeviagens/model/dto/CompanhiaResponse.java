package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CompanhiaResponse {

    private Long id;

    private String nome;

    private String pais;

    public CompanhiaResponse(Companhia companhia) {
        this.id = companhia.getId();
        this.nome = companhia.getNome();
        this.pais = companhia.getPais().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }
}
