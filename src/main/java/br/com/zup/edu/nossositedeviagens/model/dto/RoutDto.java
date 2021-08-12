package br.com.zup.edu.nossositedeviagens.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zup.edu.nossositedeviagens.model.Rout;
import br.com.zup.edu.nossositedeviagens.repository.AeroportReposity;

public class RoutDto {
    private String nomeRota;

    @NotNull
    private Long idAeroportoOrigem;

    @NotNull
    private Long idAeroportoDestino;

    @NotNull
    @Positive
    private Integer tempoRota;

    public RoutDto() {
    }

    public RoutDto(String nomeRota, Long idAeroportoOrigem, Long idAeroportoDestino, Integer tempoRota) {
        this.nomeRota = nomeRota;
        this.idAeroportoOrigem = idAeroportoOrigem;
        this.idAeroportoDestino = idAeroportoDestino;
        this.tempoRota = tempoRota;
    }

    public Rout converter(AeroportReposity aeroportoRepository){
        var aeroportoOrigem = aeroportoRepository.findById(idAeroportoOrigem).get();
        var aeroportoDestino = aeroportoRepository.findById(idAeroportoDestino).get();
        if(nomeRota == null || nomeRota.isBlank()){
            return new Rout(aeroportoOrigem, aeroportoDestino, tempoRota);
        }
        return new Rout(nomeRota, aeroportoOrigem, aeroportoDestino, tempoRota);
    }
}
