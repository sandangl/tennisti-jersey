package it.unibas.tennistirest.persistenza.mock;

import it.unibas.tennistirest.modello.Tennista;
import it.unibas.tennistirest.persistenza.IDAOTennista;
import java.util.ArrayList;
import java.util.List;

public class DAOTennistaMock extends DAOGenericoMock<Tennista> implements IDAOTennista{

    @Override
    public List<Tennista> findByRanking(Integer ranking) {
        List<Tennista> tennisti = new ArrayList<>();
        for (Tennista t : this.findAll()) {
            if(t.getRanking() == ranking){
                tennisti.add(t);
            }
        }
        return tennisti;
    }
    
}
