package it.unibas.tennistirest.persistenza.mock;

import it.unibas.tennistirest.modello.Risultato;
import it.unibas.tennistirest.persistenza.IDAORisultato;
import java.util.ArrayList;
import java.util.List;

public class DAORisultatoMock extends DAOGenericoMock<Risultato> implements IDAORisultato{

    @Override
    public List<Risultato> findByTennista(Long idTennista) {
        List<Risultato> risultati = new ArrayList<>();
        for (Risultato r : this.findAll()) {
            if(r.getTennista().getId() == idTennista){
                risultati.add(r);
            }
        }
        return risultati;
    }

}
