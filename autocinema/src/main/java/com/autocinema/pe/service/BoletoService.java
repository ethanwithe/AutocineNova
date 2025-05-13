package com.autocinema.pe.service;

import java.util.List;

import com.autocinema.pe.entity.Boleto;

public interface BoletoService {
	
	List<Boleto> listarBoletos(); 
    Boleto getIdBoletos(Long id);
    void crearActualizarBoletos(Boleto boleto); 
    void eliminarBoletos(Long id); 
    Boleto buscarPorId(Long id); 
    void guardar(Boleto boleto); 

}
