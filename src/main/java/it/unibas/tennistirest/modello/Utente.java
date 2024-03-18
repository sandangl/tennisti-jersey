package it.unibas.tennistirest.modello;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Utente {

    private long id;
    private String email;
    private String password;
    private String nome;
    private String cognome;

    public Utente(String email, String password, String nome, String cognome) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
    }

}
