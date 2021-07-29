package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Companhia;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CompanhiaDto {

    @NotBlank
    private String nome;

    @NotNull
    private Long pais;

    public CompanhiaDto(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Companhia converter() {
        return new Companhia();
    }
}
