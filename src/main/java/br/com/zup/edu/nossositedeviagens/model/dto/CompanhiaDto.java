package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.model.Companhia;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanhiaDto {

    @NotBlank
    private String nome;

    @NotNull
    private Long pais;

    public CompanhiaDto(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Companhia converter(PaisRepository paisRepository) {
        var pais = paisRepository.getById(this.pais);

        return new Companhia(this.nome, pais);
    }
}
