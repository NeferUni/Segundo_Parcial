package co.edu.ufps.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.entity.Pais;
import co.edu.ufps.repository.PaisRepository;

import java.util.List;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository paisRepository;

    @GetMapping
    public List<Pais> getAllPaises() {
        return paisRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> getPaisById(@PathVariable Long id) {
        Pais pais = paisRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(pais);
    }

    @PostMapping
    public Pais createPais(@RequestBody Pais pais) {
        return paisRepository.save(pais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> updatePais(@PathVariable Long id, @RequestBody Pais paisDetails) {
        Pais pais = paisRepository.findById(id).orElseThrow();
        pais.setNombre(paisDetails.getNombre());
        final Pais updatedPais = paisRepository.save(pais);
        return ResponseEntity.ok(updatedPais);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Long id) {
        Pais pais = paisRepository.findById(id).orElseThrow();
        paisRepository.delete(pais);
        return ResponseEntity.noContent().build();
    }
}
