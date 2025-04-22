package com.autocinema.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autocinema.pe.entity.Pelicula;
import com.autocinema.pe.repository.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> listarPelicula() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula getIdPelicula(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarPelicula(Pelicula pelicula) {
        Pelicula p = new Pelicula();
        p.setId(pelicula.getId());
        p.setTitulo(pelicula.getTitulo());
        p.setDescripcion(pelicula.getDescripcion());
        p.setDuracion(pelicula.getDuracion());
        p.setCategoria_id(pelicula.getCategoria_id());
        peliculaRepository.save(p);
    }

    @Override
    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}
