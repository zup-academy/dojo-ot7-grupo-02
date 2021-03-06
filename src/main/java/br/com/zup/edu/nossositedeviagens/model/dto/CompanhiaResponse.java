package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Companhia;

public class CompanhiaResponse {

    private Long id;

    private String nome;

    private PaisResponse pais;

    public CompanhiaResponse(Companhia companhia) {
        this.id = companhia.getId();
        this.nome = companhia.getNome();
        this.pais = new PaisResponse(companhia.getPais());
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
