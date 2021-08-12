package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.Repository.PaisRepository;
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

    public Aeroport converter(PaisRepository paisRepository) {
        var pais = paisRepository.getById(this.pais);

        return new Aeroport(this.nome, pais);
    }
}
