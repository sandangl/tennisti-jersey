package it.unibas.tennistirest.service;

import it.unibas.tennistirest.modello.Utente;
import it.unibas.tennistirest.modello.dto.UtenteDTO;
import it.unibas.tennistirest.persistenza.DAOFactory;
import it.unibas.tennistirest.persistenza.IDAOUtente;
import it.unibas.tennistirest.util.JWTUtil;
import it.unibas.tennistirest.util.Mapper;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@ApplicationScoped
@Slf4j
public class ServiceUtenti {
    
    private IDAOUtente daoUtente = DAOFactory.getInstance().getDaoUtente();
    
    public UtenteDTO login(UtenteDTO utenteDto){
        Utente u = this.daoUtente.findByEmail(utenteDto.getEmail());
        if(u == null){
            throw new IllegalArgumentException("Utente inesistente.");
        }
        if(!u.getPassword().equals(utenteDto.getPassword())){
            throw new IllegalArgumentException("Password errata.");
        }
        UtenteDTO loggato = Mapper.map(u, UtenteDTO.class);
        loggato.setPassword(JWTUtil.generaToken(utenteDto.getEmail()));
        return loggato;
    }
    
}
