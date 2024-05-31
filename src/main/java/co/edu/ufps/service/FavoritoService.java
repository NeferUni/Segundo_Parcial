package co.edu.ufps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entity.Favorito;
import co.edu.ufps.repository.FavoritoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class FavoritoService {
    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> findAll() {
        return favoritoRepository.findAll();
    }

    public Optional<Favorito> findById(Long id) {
        return favoritoRepository.findById(id);
    }

    public Favorito save(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public void delete(Long id) {
    	favoritoRepository.deleteById(id);
    }
}
