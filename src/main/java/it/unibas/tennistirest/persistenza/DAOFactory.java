package it.unibas.tennistirest.persistenza;

import it.unibas.tennistirest.modello.Configurazione;

import static it.unibas.tennistirest.enums.EStrategiaPersistenza.DB_HIBERNATE;
import it.unibas.tennistirest.persistenza.mock.DAORisultatoMock;
import it.unibas.tennistirest.persistenza.mock.DAOTennistaMock;
import it.unibas.tennistirest.persistenza.mock.DAOUtenteMock;

public class DAOFactory {

    private static final DAOFactory singleton = new DAOFactory();
    private IDAOUtente daoUtente;
    private IDAOTennista daoTennista;
    private IDAORisultato daoRisultato;

    public IDAOUtente getDaoUtente() {
        return daoUtente;
    }

    public IDAOTennista getDaoTennista() {
        return daoTennista;
    }

    public IDAORisultato getDaoRisultato() {
        return daoRisultato;
    }

    public static DAOFactory getInstance() {
        return singleton;
    }

    private DAOFactory() {
        if (Configurazione.getInstance().getStrategiaDb().equals(DB_HIBERNATE)) {

        } else {
            this.daoUtente = new DAOUtenteMock();
            this.daoTennista = new DAOTennistaMock();
            this.daoRisultato = new DAORisultatoMock();
        }
    }

}
