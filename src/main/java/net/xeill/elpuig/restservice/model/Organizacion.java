package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organizacion")
public class Organizacion {
    @Id
    @Column(name = "org_name")
    private String nombre;
//    @ManyToOne
//    private List<Jugador> jugadores;

    public Organizacion(String nombre) {
        this.nombre = nombre;
    }

    public Organizacion() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
