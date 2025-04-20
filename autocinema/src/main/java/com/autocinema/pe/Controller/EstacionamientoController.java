package com.autocinema.pe.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.autocinema.pe.entity.Estacionamiento;
import com.autocinema.pe.service.EstacionamientoService;

@Controller
@RequestMapping("/estacionamientos")
public class EstacionamientoController {

    @Autowired
    private EstacionamientoService estacionamientoService;

    @GetMapping
    public String listarEstacionamiento(Model model) {
        List<Estacionamiento> lista = estacionamientoService.listarEstacionamiento();
        model.addAttribute("listaEstacionamiento", lista);
        model.addAttribute("estacionamiento", new Estacionamiento());
        return "estacionamientos";
    }

    @PostMapping("/guardar")
    public String guardarEstacionamiento(@ModelAttribute Estacionamiento estacionamiento) {
        estacionamientoService.crearActualizarEstacionamiento(estacionamiento);
        return "redirect:/estacionamientos";
    }

    @GetMapping("/editar/{id}")
    public String editarEstacionamiento(@PathVariable Long id, Model model) {
        Estacionamiento estacionamiento = estacionamientoService.getIdEstacionamiento(id);
        model.addAttribute("estacionamiento", estacionamiento);
        model.addAttribute("listaEstacionamiento", estacionamientoService.listarEstacionamiento());
        return "estacionamientos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstacionamiento(@PathVariable Long id) {
        estacionamientoService.eliminarEstacionamiento(id);
        return "redirect:/estacionamientos";
    }
}