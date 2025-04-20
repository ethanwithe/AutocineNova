package com.autocinema.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autocinema.pe.entity.Funciones;
import com.autocinema.pe.repository.FuncionesRepository;

@Service
public class FuncionesServiceImpl  implements FuncionesService{

	@Autowired
	private FuncionesRepository funcionesRepository;
	
	
	@Override
	public List<Funciones> listarFunciones() {
		// TODO Auto-generated method stub
		return funcionesRepository.findAll();
	}

	@Override
	public Funciones getIdFunciones(Long id) {
		// TODO Auto-generated method stub
		return funcionesRepository.findById(id).orElse(null);
	}

	@Override
	public void crearActualizarFunciones(Funciones funciones) {
		Funciones fcn = new Funciones();
		fcn.setId(funciones.getId());
		fcn.setFecha(funciones.getFecha());
		fcn.setHora(funciones.getHora());
		fcn.setPelicula(funciones.getPelicula());
		fcn.setSala(funciones.getSala());
		funcionesRepository.save(fcn);
	}

	@Override
	public void eliminarFunciones(Long id) {
		funcionesRepository.deleteById(id);
	}
	
}
