package com.autocinema.pe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocinema.pe.entity.MetodoPago;
import com.autocinema.pe.service.MetodoPagoService;

@Controller
@RequestMapping("/metodoPagos")
public class MetodoPagoController {
	
	@Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public String listarMetodoPago(Model model) {
        List<MetodoPago> lista = metodoPagoService.listarMetodoPago();
        model.addAttribute("listaMetodoPago", lista);
        model.addAttribute("metodoPago", new MetodoPago());
        return "metodoPagos";
    }

    @PostMapping("/guardar")
    public String guardarMetodoPago(@ModelAttribute MetodoPago metodoPago) {
        metodoPagoService.crearActualizarMetodoPago(metodoPago);
        return "redirect:/metodoPagos";
    }

    @GetMapping("/editar/{id}")
    public String editarMetodoPago(@PathVariable Long id, Model model) {
        MetodoPago metodoPago = metodoPagoService.getIdMetodoPago(id);
        model.addAttribute("metodoPago", metodoPago);
        model.addAttribute("listaMetodoPago", metodoPagoService.listarMetodoPago());
        return "metodoPagos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMetodoPago(@PathVariable Long id) {
        metodoPagoService.eliminarMetodoPago(id);
        return "redirect:/metodoPagos";
    }

}
