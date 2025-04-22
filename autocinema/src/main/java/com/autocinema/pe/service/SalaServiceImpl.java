package com.autocinema.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinema.pe.entity.Sala;
import com.autocinema.pe.repository.SalaRepository;

@Service
public class SalaServiceImpl implements SalaService {
    @Autowired
    private SalaRepository salaRepository;

    @Override
    public List<Sala> listarSala() {
        return salaRepository.findAll();
    }

    @Override
    public Sala getIdSala(Long id) {
        return salaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarSala(Sala sala) {
        Sala s = new Sala();
        s.setId(sala.getId());
        s.setNombre(sala.getNombre());
        s.setCapacidad(sala.getCapacidad());
        s.setSede_id(sala.getSede_id());
        salaRepository.save(s);
    }

    @Override
    public void eliminarSala(Long id) {
        salaRepository.deleteById(id);
    }
}
