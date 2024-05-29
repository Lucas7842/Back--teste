package org.example.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "usuario", nullable = false, length = 100)
    private String usuario;

    @Column(name = "nome", nullable = false,length = 100)
    private String nome;

    @Column(name = "email", nullable = false,  length = 100)
    private String email;

    @Column(name = "senha", nullable = false,  length = 100)
    private String senha;

    @Column(name = "datadenascimento",  length = 100)
    private String datadenascimento;

    public enum Role{
        ROLE_ADMIN, ROLE_CLIENTE
    }

    public Usuario(String usuario, String nome, String email, String senha, String datadenascimento){
        this.usuario = usuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.datadenascimento = datadenascimento;
    }
      @Override
    public boolean equals(Object o){
        if(this ==o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return java.util.Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
    @Override
    public String toString(){
        return"Usuario{"+
                "id=" + id +
                '}';
    }

}
