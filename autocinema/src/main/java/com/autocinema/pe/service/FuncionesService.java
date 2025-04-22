package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Funciones;

public interface FuncionesService {
	List<Funciones> listarFunciones();
	Funciones getIdFunciones(Long id);
	void crearActualizarFunciones(Funciones funciones);
	void eliminarFunciones(Long id);

	
}
