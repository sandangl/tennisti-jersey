package it.unibas.tennistirest.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import it.unibas.tennistirest.modello.dto.UtenteDTO;
import it.unibas.tennistirest.service.ServiceUtenti;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@RequestScoped
@Path("/utenti")
@SecurityRequirement(name="bearerAuth")
@Consumes(MediaType.APPLICATION_JSON)
public class RisorsaUtenti {
    
    @Context
    SecurityContext securityContext;
    
    @Inject
    ServiceUtenti serviceUtenti;
    
    @POST
    @PermitAll
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public UtenteDTO login(@Valid @NotNull UtenteDTO utenteDTO){
        return serviceUtenti.login(utenteDTO);
    } 
    
}
