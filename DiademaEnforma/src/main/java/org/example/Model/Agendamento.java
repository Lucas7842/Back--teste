package org.example.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "agendamento")

public class Agendamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "data", nullable = false, length = 100)
    private String data;

    @Column(name = "horario", nullable = false, length = 100)
    private String horario;

    @Column(name = "local", nullable = false, length = 100)
    private String local;

    public enum Role{
        ROLE_ADMIN, ROLE_AGENDAMENTO
    }

    public Agendamento(String data, String horario, String local){
        this.data = data;
        this.horario = horario;
        this.local = local;
    }
    @Override
    public boolean equals(Object o){
        if( this == o) return true;
        if (o == null ||  getClass() != o.getClass()) return false;
        Agendamento agendamento = (Agendamento) o;
        return java.util.Objects.equals(id, agendamento.id);

    }
    @Override
    public int hashCode(){
        return java.util.Objects.hash(id);
    }
    @Override
    public String toString(){
        return "Agendamento{"+
                "id=" + id +
                '}';
    }

}
