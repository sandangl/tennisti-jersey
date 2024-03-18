package it.unibas.tennistirest.persistenza.mock;

import it.unibas.tennistirest.enums.ESponsor;
import it.unibas.tennistirest.modello.Risultato;
import it.unibas.tennistirest.modello.Tennista;
import it.unibas.tennistirest.modello.Utente;

public class RepositoryMock extends RepositoryGenericoMock {

    private static final RepositoryMock singleton = new RepositoryMock();

    private RepositoryMock() {

        Utente u1 = new Utente("admin@unibas.it", "Admin!", "Admin", "Unibas");
        Utente u2 = new Utente("utente@unibas.it", "Utente!", "Utente", "Unibas");
        this.saveOrUpdate(u1);
        this.saveOrUpdate(u2);

        Tennista t1 = new Tennista("Jannik Sinner", ESponsor.HEAD, 1, 12);
        Tennista t2 = new Tennista("Novak Djokovic", ESponsor.HEAD, 1, 50);
        Tennista t3 = new Tennista("Carlos Alcaraz", ESponsor.BABOLAT, 2, 10);
        this.saveOrUpdate(t1);
        this.saveOrUpdate(t2);
        this.saveOrUpdate(t3);

        Risultato r1 = new Risultato("Australian Open", 1, 2000, t1);
        Risultato r2 = new Risultato("Miami", 2, 500, t1);
        this.saveOrUpdate(r1);
        this.saveOrUpdate(r2);

    }

    public static RepositoryMock getInstance() {
        return singleton;
    }

}
