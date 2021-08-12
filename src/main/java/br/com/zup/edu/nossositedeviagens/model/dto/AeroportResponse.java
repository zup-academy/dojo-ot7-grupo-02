package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Aeroport;

public class AeroportResponse {

    private Long id;
    private String nome;
    private PaisResponse pais;

    public AeroportResponse(Aeroport createdAeroport) {
        this.id = createdAeroport.getId();
        this.nome = createdAeroport.getNome();
        this.pais = new PaisResponse(createdAeroport.getPais());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisResponse getPais() {
        return pais;
    }
}
