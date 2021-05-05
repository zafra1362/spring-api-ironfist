package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "organizador")
public class Organizador {
    @Id
    @Column(name = "id_organizador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrganizador;
    @NotBlank
    @Column(name = "user_name")
    private String nombre;
    @NotBlank
    private String canal;

    public Organizador(String canal, String nombre) {
        this.canal = canal;
        this.nombre = nombre;
    }

    public Organizador() {
    }

    public int getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(int idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }
}
