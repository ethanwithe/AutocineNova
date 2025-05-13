package com.autocinema.pe.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autocinema.pe.entity.Boleto;
import com.autocinema.pe.repository.BoletoRepository;

@Service
public class BoletoServiceImpl implements BoletoService {
	
	@Autowired
    private BoletoRepository boletoRepository;

    @Override
    public List<Boleto> listarBoletos() {
        return boletoRepository.findAll();
    }

    @Override
    public Boleto getIdBoletos(Long id) {
        return boletoRepository.findById(id).orElse(null);
    }
    
    @Override
    public Boleto buscarPorId(Long id) {
        return boletoRepository.findById(id).orElse(null);
    }

    @Override
    public void crearActualizarBoletos(Boleto boletos) {
        Boleto b = new Boleto();
        b.setId(boletos.getId());
        b.setUsuario(boletos.getUsuario());
        b.setFuncion(boletos.getFuncion());
        b.setCantidad(boletos.getCantidad());
        b.setTotal(boletos.getTotal());
        b.setMetodoP(boletos.getMetodoP());
        b.setFecha(boletos.getFecha());
        boletoRepository.save(b);
    }

    @Override
    public void eliminarBoletos(Long id) {
        boletoRepository.deleteById(id);
    }
    @Override
    public void guardar(Boleto boleto) {
        boletoRepository.save(boleto);
    }

}
