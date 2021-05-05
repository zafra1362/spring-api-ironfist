package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    private String nickname;
    @NotBlank
    @Column(name = "user_name")
    private String name;
    @NotBlank
    private String apellidos;

    private int puntuacion;

//    @NotBlank
//    @Column(name = "pj_name1")
//    private net.xeill.elpuig.restservice.model.Personaje personaje1;
//
//    @Column(name = "pj_name2")
//    private net.xeill.elpuig.restservice.model.Personaje personaje2;

   // @Column(name = "org_name")
   // @OneToMany()
   // private Organizacion organizacion;

    public Jugador() {
    }

    public Jugador(String nickname, String name, String apellidos, int puntuacion) {
        this.nickname = nickname;
        this.puntuacion = puntuacion;
        this.name = name;
        this.apellidos = apellidos;
//        this.personaje1 = personaje1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
//
//    public net.xeill.elpuig.restservice.model.Personaje getPersonaje1() {
//        return personaje1;
//    }
//
//    public void setPersonaje1(net.xeill.elpuig.restservice.model.Personaje personaje1) {
//        this.personaje1 = personaje1;
//    }
//
//    public net.xeill.elpuig.restservice.model.Personaje getPersonaje2() {
//        return personaje2;
//    }
//
//    public void setPersonaje2(net.xeill.elpuig.restservice.model.Personaje personaje2) {
//        this.personaje2 = personaje2;
//    }
//
//    public Organizacion getOrganizacion() {
//        return organizacion;
//    }
//
//    public void setOrganizacion(Organizacion organizacion) {
//        this.organizacion = organizacion;
//    }

}
