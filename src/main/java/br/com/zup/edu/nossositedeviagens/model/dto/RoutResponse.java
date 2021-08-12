package br.com.zup.edu.nossositedeviagens.model.dto;

import br.com.zup.edu.nossositedeviagens.model.Rout;

public class RoutResponse {
    private String nomeRota;
    private Integer tempoRota;

    public RoutResponse(Rout rout){
        this.nomeRota = rout.getNomeRota();
        this.tempoRota = rout.getTempoRota();
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public Integer getTempoRota() {
        return tempoRota;
    }
}
