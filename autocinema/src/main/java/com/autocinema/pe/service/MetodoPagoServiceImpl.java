package com.autocinema.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinema.pe.entity.MetodoPago;
import com.autocinema.pe.repository.MetodoPagoRepository;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> listarMetodoPago() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public MetodoPago getIdMetodoPago(Long id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarMetodoPago(Long id) {
        metodoPagoRepository.deleteById(id);
    }

	@Override
	public void crearActualizarMetodoPago(MetodoPago metodo) {
		MetodoPago mtd = new MetodoPago();
        mtd.setId(metodo.getId());
        mtd.setMetodo(metodo.getMetodo());
        metodoPagoRepository.save(mtd);

	}
}