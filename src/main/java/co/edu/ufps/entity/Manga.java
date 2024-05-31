package co.edu.ufps.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "manga")
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaLanzamiento;
    private int temporadas;
    private boolean anime;
    private boolean juego;
    private boolean pelicula;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;
}