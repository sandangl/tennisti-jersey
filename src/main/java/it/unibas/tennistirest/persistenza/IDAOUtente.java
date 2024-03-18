package it.unibas.tennistirest.persistenza;

import it.unibas.tennistirest.modello.Utente;

/**
 *
 * @author seman
 */
public interface IDAOUtente extends IDAOGenerico<Utente> {

    public Utente findByEmail(String emailUtente);
    
}
