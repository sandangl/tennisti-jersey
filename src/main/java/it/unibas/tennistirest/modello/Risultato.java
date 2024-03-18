package it.unibas.tennistirest.modello;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Risultato {

    private long id;
    private String nomeTorneo;
    private int posizione;
    private int punti;
    private Tennista tennista;

    public Risultato(String nomeTorneo, int posizione, int punti, Tennista tennista) {
        this.nomeTorneo = nomeTorneo;
        this.posizione = posizione;
        this.punti = punti;
        this.tennista = tennista;
    }

}
