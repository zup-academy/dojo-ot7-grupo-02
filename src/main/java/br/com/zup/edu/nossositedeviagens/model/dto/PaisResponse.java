package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Pais;

public class PaisResponse {

    private Long id;
    private String nome;

    public PaisResponse(Pais paisOriginal) {
        this.id = paisOriginal.getId();
        this.nome = paisOriginal.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
