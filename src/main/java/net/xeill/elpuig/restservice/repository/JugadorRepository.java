package net.xeill.elpuig.restservice.repository;

import net.xeill.elpuig.restservice.model.Jugador;
import net.xeill.elpuig.restservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JugadorRepository extends JpaRepository<Jugador, String> {

}
