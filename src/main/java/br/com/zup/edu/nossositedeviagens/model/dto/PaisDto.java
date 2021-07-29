package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Pais;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaisDto {

    @NotBlank

    private String nome;

    public PaisDto() {
    }

    public PaisDto(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais converter(){
        return new Pais( nome);
    }

    public String getNome() {
        return nome;
    }
}
