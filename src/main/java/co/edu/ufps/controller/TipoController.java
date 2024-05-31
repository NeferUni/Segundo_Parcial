package co.edu.ufps.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.entity.Tipo;
import co.edu.ufps.repository.TipoRepository;

import java.util.List;

@Controller
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoRepository tipoRepository;

    @GetMapping
    public List<Tipo> getAllTipos() {
        return tipoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tipo> getTipoById(@PathVariable Long id) {
        Tipo tipo = tipoRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(tipo);
    }

    @PostMapping
    public Tipo createTipo(@RequestBody Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tipo> updateTipo(@PathVariable Long id, @RequestBody Tipo tipoDetails) {
        Tipo tipo = tipoRepository.findById(id).orElseThrow();
        tipo.setNombre(tipoDetails.getNombre());
        final Tipo updatedTipo = tipoRepository.save(tipo);
        return ResponseEntity.ok(updatedTipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        Tipo tipo = tipoRepository.findById(id).orElseThrow();
        tipoRepository.delete(tipo);
        return ResponseEntity.noContent().build();
    }
}
