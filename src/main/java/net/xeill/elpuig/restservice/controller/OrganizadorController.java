package net.xeill.elpuig.restservice.controller;

import net.xeill.elpuig.restservice.exception.ResourceNotFoundException;
import net.xeill.elpuig.restservice.model.Organizador;
import net.xeill.elpuig.restservice.repository.OrganizadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost"})
@RequestMapping("/api")
public class OrganizadorController {

    @Autowired
    OrganizadorRepository organizadorRepository;


    @GetMapping("/organizadores")
    public List<Organizador> getAllOrganizadores() {
        return organizadorRepository.findAll();
    }

    @PostMapping("/organizadores")
    //public Note createNote(@Valid @RequestBody Note note) {
    //https://stackoverflow.com/questions/51337489/content-type-multipart-form-databoundary-webkitformboundary-not-suppor
    public Organizador createOrganizador(@Valid @RequestBody Organizador organizador) {
        return organizadorRepository.save(organizador);
    }

    @GetMapping("/organizadores/{id}")
    public Organizador getOrganizadorById(@PathVariable(value = "id") int orgId) {
        return organizadorRepository.findById(orgId)
                .orElseThrow(() -> new ResourceNotFoundException("Organizador", "id", orgId));
    }

    @PutMapping("/organizadores/{id}")
    public Organizador updateOrganizador(@PathVariable(value = "id") int orgId,
                                 @Valid @RequestBody Organizador organizadorDetails) {

        Organizador organizador = organizadorRepository.findById(orgId)
                .orElseThrow(() -> new ResourceNotFoundException("Organizador", "id", orgId));

        organizador.setNombre(organizadorDetails.getNombre());
        organizador.setCanal(organizadorDetails.getCanal());

        Organizador updatedOrganizador = organizadorRepository.save(organizador);
        return updatedOrganizador;
    }

    @DeleteMapping("/organizador/id}")
    public ResponseEntity<?> deleteOrganizador(@PathVariable(value = "id") int orgId) {
        Organizador organizador = organizadorRepository.findById(orgId)
                .orElseThrow(() -> new ResourceNotFoundException("Organizador", "id", orgId));

        organizadorRepository.delete(organizador);

        return ResponseEntity.ok().build();
    }
}
