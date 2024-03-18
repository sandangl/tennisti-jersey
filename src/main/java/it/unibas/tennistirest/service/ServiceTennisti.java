package it.unibas.tennistirest.service;

import it.unibas.tennistirest.modello.Tennista;
import it.unibas.tennistirest.modello.dto.TennistaDTO;
import it.unibas.tennistirest.persistenza.DAOFactory;
import it.unibas.tennistirest.persistenza.IDAOTennista;
import it.unibas.tennistirest.persistenza.IDAOUtente;
import it.unibas.tennistirest.util.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ServiceTennisti {

    IDAOUtente daoUtente = DAOFactory.getInstance().getDaoUtente();
    IDAOTennista daoTennista = DAOFactory.getInstance().getDaoTennista();
    
    public List<TennistaDTO> tennistiRanking(Integer ranking, String name) {
        if(this.daoUtente.findByEmail(name) == null){
            throw new IllegalArgumentException("Utente inesistente.");
        }
        List<Tennista> tennisti = this.daoTennista.findByRanking(ranking);
        return Mapper.map(tennisti, TennistaDTO.class);
    }
    
}
