package it.unibas.tennistirest.modello.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RisultatoDTO {

    private Long id;
    @NotBlank
    private String nomeTorneo;
    @Min(1)
    private int posizione;
    private int punti;
    @NotNull
    private Long idTennista;

}
