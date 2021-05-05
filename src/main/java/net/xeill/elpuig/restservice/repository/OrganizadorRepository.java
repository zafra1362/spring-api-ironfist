package net.xeill.elpuig.restservice.repository;

import net.xeill.elpuig.restservice.model.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizadorRepository extends JpaRepository<Organizador, Integer> {
}
