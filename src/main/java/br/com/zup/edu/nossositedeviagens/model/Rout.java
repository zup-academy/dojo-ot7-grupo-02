package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"aeroportoOrigem", "aeroportoDestino"})})
public class Rout{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String nomeRota;

    @NotNull
    @ManyToOne
    private Aeroport aeroportoOrigem;

    @NotNull
    @ManyToOne
    private Aeroport aeroportoDestino;

    @NotNull
    @Positive
    private Integer tempoRota;

    public Rout(String nomeRota, Aeroport aeroportoOrigem, Aeroport aeropotoDestino, Integer tempoRota) {
        this(aeroportoOrigem, aeropotoDestino, tempoRota);
        this.nomeRota = nomeRota;
    }

    public Rout(Aeroport aeroportoOrigem, Aeroport aeroportoDestino, Integer tempoRota){
        Assert.isTrue(!aeroportoOrigem.equals(aeroportoDestino), "Erro: aeroportos de origem e destino sao iguais");
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.nomeRota = rotaConcatToString(aeroportoOrigem, aeroportoDestino);
        this.tempoRota = tempoRota;
    }

    public String rotaConcatToString(Aeroport aeroportoOrigem, Aeroport aeroportoDestino){
        nomeRota = aeroportoOrigem.getNome() + "-" + aeroportoDestino.getNome();
        return nomeRota;
    }

    public Long getId() {
        return id;
    }

    public String getNomeRota() {
        return nomeRota;
    }

    public Aeroport getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public Aeroport getAeroportoDestino() {
        return aeroportoDestino;
    }

    public Integer getTempoRota() {
        return tempoRota;
    }
}
