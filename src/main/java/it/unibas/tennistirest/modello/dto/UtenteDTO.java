

package it.unibas.tennistirest.modello.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtenteDTO {
    
    @Email
    private String email;
    @NotBlank
    private String authToken;
    private String nome;
    private String cognome;

}
