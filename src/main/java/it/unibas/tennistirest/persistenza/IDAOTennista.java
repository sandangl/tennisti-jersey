package it.unibas.tennistirest.persistenza;

import it.unibas.tennistirest.modello.Tennista;
import java.util.List;

/**
 *
 * @author seman
 */
public interface IDAOTennista extends IDAOGenerico<Tennista>{

    public List<Tennista> findByRanking(Integer ranking);
    
}
