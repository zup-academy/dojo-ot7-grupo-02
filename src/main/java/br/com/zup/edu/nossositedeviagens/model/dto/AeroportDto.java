package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Aeroport;

public class AeroportDto {

    private String nome;

    private Long pais;

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }



    public AeroportDto(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Aeroport converter(){


    }

}
