package co.edu.ufps.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ufps.entity.Pais;
import co.edu.ufps.repository.PaisRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }

    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    public void delete(Long id) {
        paisRepository.deleteById(id);
    }
}
