package co.edu.ufps.controller;

import co.edu.ufps.entity.Favorito;
import co.edu.ufps.service.FavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping
    public List<Favorito> getAllFavoritos() {
        return favoritoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> getFavoritoById(@PathVariable Long id) {
        Optional<Favorito> favorito = favoritoService.findById(id);
        if (favorito.isPresent()) {
            return ResponseEntity.ok(favorito.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Favorito createFavorito(@RequestBody Favorito favorito) {
        return favoritoService.save(favorito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorito> updateFavorito(@PathVariable Long id, @RequestBody Favorito favoritoDetails) {
        Optional<Favorito> favorito = favoritoService.findById(id);
        if (favorito.isPresent()) {
            Favorito existingFavorito = favorito.get();
            existingFavorito.setUsuario(favoritoDetails.getUsuario());
            existingFavorito.setManga(favoritoDetails.getManga());
            Favorito updatedFavorito = favoritoService.save(existingFavorito);
            return ResponseEntity.ok(updatedFavorito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorito(@PathVariable Long id) {
        Optional<Favorito> favorito = favoritoService.findById(id);
        if (favorito.isPresent()) {
            favoritoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
