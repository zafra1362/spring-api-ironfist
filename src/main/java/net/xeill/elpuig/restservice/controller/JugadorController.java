package net.xeill.elpuig.restservice.controller;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
import net.xeill.elpuig.restservice.model.Jugador;
import net.xeill.elpuig.restservice.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost"})
@RequestMapping("/api")
public class JugadorController {

    @Autowired
    JugadorRepository jugadorRepository;


    @GetMapping("/jugadores")
    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    @PostMapping("/jugadores")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public Jugador createUser(@Valid @RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @GetMapping("/jugadores/{nickname}")
    public Jugador getJugadorByNickname(@PathVariable(value = "nickname") String jugadorNickname) {
        return jugadorRepository.findById(jugadorNickname)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador", "nickname", jugadorNickname));
    }

    @PutMapping("/jugadores/{nickname}")
    public Jugador updateJugador(@PathVariable(value = "nickname") String jugadorNickname,
                           @Valid @RequestBody Jugador jugadorDetails) {

        Jugador jugador = jugadorRepository.findById(jugadorNickname)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador", "nickname", jugadorNickname));

        jugador.setName(jugadorDetails.getName());
        jugador.setApellidos(jugadorDetails.getApellidos());
        jugador.setPuntuacion(jugadorDetails.getPuntuacion());

        Jugador updatedJugador = jugadorRepository.save(jugador);
        return updatedJugador;
    }

    @DeleteMapping("/jugadores/{nickname}")
    public ResponseEntity<?> deleteJugador(@PathVariable(value = "nickname") String jugadorNickname) {
        Jugador jugador = jugadorRepository.findById(jugadorNickname)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador", "nickname", jugadorNickname));

        jugadorRepository.delete(jugador);

        return ResponseEntity.ok().build();
    }
}
