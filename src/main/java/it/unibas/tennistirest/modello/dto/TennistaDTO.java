package it.unibas.tennistirest.modello.dto;

import it.unibas.tennistirest.enums.ESponsor;
import lombok.Data;

@Data
public class TennistaDTO {
    
    private String nome;
    private ESponsor sponsor;
    private int ranking;
    private int numeroTitoli;
}
