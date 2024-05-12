package org.example.Model;

import java.time.LocalDate;

public record UsuarioDTO (
        String usuario,
        String nome,
        String email,
        String senha,
        String datadenascimento){

}
