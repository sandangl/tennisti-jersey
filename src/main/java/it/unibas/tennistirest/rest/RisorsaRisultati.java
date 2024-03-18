package it.unibas.tennistirest.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.unibas.tennistirest.modello.dto.RisultatoDTO;
import it.unibas.tennistirest.service.ServiceRisultati;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import java.util.List;

@RequestScoped
@SecurityRequirement(name="bearerAuth")
@Path("/risultati")
@Produces(MediaType.APPLICATION_JSON)
public class RisorsaRisultati {
    
    @Context
    SecurityContext securityContext;
    
    @Inject
    ServiceRisultati serviceRisultati;
    
    @GET
    public List<RisultatoDTO> getRisultatiTennista(@QueryParam("idTennista") Long idTennista){
        return this.serviceRisultati.getRisultatiTennista(idTennista, this.securityContext.getUserPrincipal().getName());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public long aggiungiRisultato(@NotNull @Valid RisultatoDTO risultato){
        return this.serviceRisultati.aggiungiRisultato(risultato, this.securityContext.getUserPrincipal().getName());
    }
    
}
