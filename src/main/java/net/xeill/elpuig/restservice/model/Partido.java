package net.xeill.elpuig.restservice.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Table(name = "partido")
public class Partido {
    @Id
    @Column(name = "id_partido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPartido;

    @NotBlank
    private int resultadoLocal, resultadoVisitante, puntuacionLocal, puntuacionVisitante;

    @NotBlank
    @OneToOne
    @JoinColumn(name="nickname")
    private Jugador jugadorLocal;

    @NotBlank
    @OneToOne
    @JoinColumn(name="nickname")
    private Jugador jugadorVisitante;

    @NotBlank
    @OneToOne
    @JoinColumn(name="id_organizador")
    private Organizador organizador;

    public Partido(int idPartido, Jugador jugadorLocal, Jugador jugadorVisitante, Organizador organizador) {
        this.idPartido = idPartido;
        this.jugadorLocal = jugadorLocal;
        this.jugadorVisitante = jugadorVisitante;
        this.organizador = organizador;
    }

    public Partido() {
    }

    public void play(Jugador jugadorLocal, Jugador jugadorVisitante, int resultadoLocal, int resultadoVisitante) {
        int puntuacionResultante = (int) (Math.random() * 50);

        if (resultadoLocal > resultadoVisitante) {
            puntuacionLocal = (jugadorLocal.getPuntuacion() + puntuacionResultante);
            jugadorLocal.setPuntuacion(puntuacionLocal);

            puntuacionVisitante = (jugadorVisitante.getPuntuacion() - puntuacionResultante);
            jugadorVisitante.setPuntuacion(puntuacionVisitante);

        } else if (resultadoLocal < resultadoVisitante){
            puntuacionLocal = (jugadorLocal.getPuntuacion() - puntuacionResultante);
            jugadorLocal.setPuntuacion(puntuacionLocal);

            puntuacionVisitante = (jugadorVisitante.getPuntuacion() + puntuacionResultante);
            jugadorVisitante.setPuntuacion(puntuacionVisitante);

        } else  {
            System.out.println("No puede haber un empate.");
        }
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getResultadoLocal() {
        return resultadoLocal;
    }

    public void setResultadoLocal(int resultadoLocal) {
        this.resultadoLocal = resultadoLocal;
    }

    public int getResultadoVisitante() {
        return resultadoVisitante;
    }

    public void setResultadoVisitante(int resultadoVisitante) {
        this.resultadoVisitante = resultadoVisitante;
    }

    public int getPuntuacionLocal() {
        return puntuacionLocal;
    }

    public void setPuntuacionLocal(int puntuacionLocal) {
        this.puntuacionLocal = puntuacionLocal;
    }

    public int getPuntuacionVisitante() {
        return puntuacionVisitante;
    }

    public void setPuntuacionVisitante(int puntuacionVisitante) {
        this.puntuacionVisitante = puntuacionVisitante;
    }

    public Jugador getJugadorLocal() {
        return jugadorLocal;
    }

    public void setJugadorLocal(Jugador jugadorLocal) {
        this.jugadorLocal = jugadorLocal;
    }

    public Jugador getJugadorVisitante() {
        return jugadorVisitante;
    }

    public void setJugadorVisitante(Jugador jugadorVisitante) {
        this.jugadorVisitante = jugadorVisitante;
    }
}
