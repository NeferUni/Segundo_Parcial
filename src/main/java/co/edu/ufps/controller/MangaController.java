package co.edu.ufps.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.entity.Manga;
import co.edu.ufps.repository.MangaRepository;

import java.util.List;

@RestController
@RequestMapping("/mangas")
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    @GetMapping
    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manga> getMangaById(@PathVariable Long id) {
        Manga manga = mangaRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(manga);
    }

    @PostMapping
    public Manga createManga(@RequestBody Manga manga) {
        return mangaRepository.save(manga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manga> updateManga(@PathVariable Long id, @RequestBody Manga mangaDetails) {
        Manga manga = mangaRepository.findById(id).orElseThrow();
        manga.setNombre(mangaDetails.getNombre());
        manga.setFechaLanzamiento(mangaDetails.getFechaLanzamiento());
        manga.setTemporadas(mangaDetails.getTemporadas());
        manga.setAnime(mangaDetails.isAnime());
        manga.setJuego(mangaDetails.isJuego());
        manga.setPelicula(mangaDetails.isPelicula());
        manga.setPais(mangaDetails.getPais());
        manga.setTipo(mangaDetails.getTipo());
        final Manga updatedManga = mangaRepository.save(manga);
        return ResponseEntity.ok(updatedManga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManga(@PathVariable Long id) {
        Manga manga = mangaRepository.findById(id).orElseThrow();
        mangaRepository.delete(manga);
        return ResponseEntity.noContent().build();
    }
}
