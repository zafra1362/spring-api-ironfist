package net.xeill.elpuig.restservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personaje")
public class Personaje {
    @Id
    @Column(name = "pj_name")
    private String nombre;

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public Personaje() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
