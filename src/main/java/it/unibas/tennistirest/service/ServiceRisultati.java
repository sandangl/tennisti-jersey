package it.unibas.tennistirest.service;

import it.unibas.tennistirest.modello.Risultato;
import it.unibas.tennistirest.modello.Tennista;
import it.unibas.tennistirest.modello.dto.RisultatoDTO;
import it.unibas.tennistirest.persistenza.DAOFactory;
import it.unibas.tennistirest.persistenza.IDAORisultato;
import it.unibas.tennistirest.persistenza.IDAOTennista;
import it.unibas.tennistirest.persistenza.IDAOUtente;
import it.unibas.tennistirest.util.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ServiceRisultati {

    IDAOUtente daoUtente = DAOFactory.getInstance().getDaoUtente();
    IDAORisultato daoRisultato = DAOFactory.getInstance().getDaoRisultato();
    IDAOTennista daoTennista = DAOFactory.getInstance().getDaoTennista();
    
    public List<RisultatoDTO> getRisultatiTennista(Long idTennista, String name) {
        if(this.daoUtente.findByEmail(name) == null){
            throw new IllegalArgumentException("Utente inesistente.");
        }
        List<RisultatoDTO> risultatiDto = new ArrayList<>();
        for (Risultato risultato : this.daoRisultato.findByTennista(idTennista)) {
            RisultatoDTO dto = Mapper.map(risultato, RisultatoDTO.class);
            dto.setIdTennista(risultato.getTennista().getId());
            risultatiDto.add(dto);
        }
        return risultatiDto;
    }

    public long aggiungiRisultato(RisultatoDTO dto, String name) {
        if(this.daoUtente.findByEmail(name) == null){
            throw new IllegalArgumentException("Utente inesistente.");
        }
        if(dto.getId() != null){
            throw new IllegalArgumentException("L'id non deve essere inizializzato.");    
        }
        Risultato risultato = Mapper.map(dto, Risultato.class);
        Tennista tennista = this.daoTennista.findById(dto.getIdTennista());
        if(tennista == null){
            throw new IllegalArgumentException("Il tennista specificato e' inesistente.");
        }
        risultato.setTennista(tennista);
        daoRisultato.makePersistent(risultato);
        return risultato.getId();
    }

}
