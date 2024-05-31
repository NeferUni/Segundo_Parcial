package co.edu.ufps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entity.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

}
