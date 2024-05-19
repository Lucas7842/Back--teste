package org.example.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarioprofissional")// precisei colocar o nome da tabela usuarioProfissional, para conectar com o banco de dados mysql
// aqui onde vai o nome da tabela que vou criar ("cadastro") eu tirei para, mas posso colocar depois.
public class UsuarioProfissional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "profissional", nullable = false,unique = true,  length = 100)
    private String profissional;

    @Column(name = "nome", nullable = false,  length = 100)
    private String nome;

    @Column(name ="telefone", nullable = false,  length = 100)
    private String telefone;

    @Column(name = "areadeatuacao", nullable = false,  length = 100)
    private String areadeatuacao;

    @Column(name = "cnpj", nullable = false,  length = 100)
    private String cnpj;

    @Column(name = "email", nullable = false,  length = 100)
    private String email;

    @Column(name = "senha", nullable = false,  length = 100)
    private String senha;

    public enum Role{
        Role_ADMIN, ROLE_CLIENTE
    }

    public UsuarioProfissional(String profissional, String nome, String telefone, String cnpj, String areadeatuacao, String email, String senha) {
        this.profissional = profissional;
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.areadeatuacao = areadeatuacao;
        this.email = email;
        this.senha = senha;
    }



    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        UsuarioProfissional usuarioProfissional = (UsuarioProfissional) o;
        return Objects.equals(id, usuarioProfissional.id);

    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        return "UsuarioProfissional{"+
                "id=" + id +
                '}';
    }
}

