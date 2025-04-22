package com.autocinema.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinema.pe.entity.Confiteria;
import com.autocinema.pe.repository.ConfiteriaRepository;


@Service
public class ConfiteriaServiceImpl implements ConfiteriaService {
    @Autowired
    private ConfiteriaRepository confiteriaRepository;

    @Override
    public List<Confiteria> listarConfiteria() {
        return confiteriaRepository.findAll();
    }

    @Override
    public Confiteria getIdConfiteria(Long id) {
        return confiteriaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarConfiteria(Confiteria item) {
        Confiteria c = new Confiteria();
        c.setId(item.getId());
        c.setNombre(item.getNombre());
        c.setPrecio(item.getPrecio());
        c.setDescripcion(item.getDescripcion());
        confiteriaRepository.save(c);
    }

    @Override
    public void eliminarConfiteria(Long id) {
        confiteriaRepository.deleteById(id);
    }
}

