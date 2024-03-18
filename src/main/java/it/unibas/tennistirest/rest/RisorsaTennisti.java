package it.unibas.tennistirest.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.unibas.tennistirest.modello.dto.TennistaDTO;
import it.unibas.tennistirest.service.ServiceTennisti;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;
import java.util.List;

@RequestScoped
@Path("/tennisti")
@SecurityRequirement(name="bearerAuth")
@Produces(MediaType.APPLICATION_JSON)
public class RisorsaTennisti {

    @Inject
    ServiceTennisti serviceTennisti;
    
    @Context
    SecurityContext securityContext;
    
    @GET
    public List<TennistaDTO> tennistiRanking(@QueryParam("ranking") int ranking){
        return serviceTennisti.tennistiRanking(ranking, securityContext.getUserPrincipal().getName());
    }
    
}
