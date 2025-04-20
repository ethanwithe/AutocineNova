package com.autocinema.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autocinema.pe.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {}