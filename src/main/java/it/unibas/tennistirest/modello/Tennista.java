package it.unibas.tennistirest.modello;

import it.unibas.tennistirest.enums.ESponsor;
import lombok.Data;

@Data
public class Tennista {

    private long id;
    private String nome;
    private ESponsor sponsor;
    private int ranking;
    private int numeroTitoli;

    public Tennista(String nome, ESponsor sponsor, int ranking, int numeroTitoli) {
        this.nome = nome;
        this.sponsor = sponsor;
        this.ranking = ranking;
        this.numeroTitoli = numeroTitoli;
    }

}
