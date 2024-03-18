package it.unibas.tennistirest.persistenza.mock;

import it.unibas.tennistirest.modello.Utente;
import it.unibas.tennistirest.persistenza.IDAOUtente;

public class DAOUtenteMock extends DAOGenericoMock<Utente> implements IDAOUtente{

    @Override
    public Utente findByEmail(String emailUtente) {
        for (Utente u : this.findAll()) {
            if(u.getEmail().equals(emailUtente)){
                return u;
            }
        }
        return null;
    }

}
