package it.unibas.tennistirest.persistenza;

import it.unibas.tennistirest.modello.Risultato;
import java.util.List;

/**
 *
 * @author seman
 */
public interface IDAORisultato extends IDAOGenerico<Risultato>{

    public List<Risultato> findByTennista(Long idTennista);
    
}
