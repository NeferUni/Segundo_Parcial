package co.edu.ufps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ufps.entity.Manga;

public interface MangaRepository extends JpaRepository<Manga, Long> {

}
