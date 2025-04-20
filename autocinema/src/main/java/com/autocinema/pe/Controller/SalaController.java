package com.autocinema.pe.Controller;

import com.autocinema.pe.entity.Sala;
import com.autocinema.pe.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salas")

public class SalaController {
	
	@Autowired
    private SalaService salaService;

    @GetMapping
    public String listarSala(Model model) {
        List<Sala> lista = salaService.listarSala();
        model.addAttribute("listaSala", lista);
        model.addAttribute("sala", new Sala());
        return "salas";
    }

    @PostMapping("/guardar")
    public String guardarSala(@ModelAttribute Sala sala) {
        salaService.crearActualizarSala(sala);
        return "redirect:/salas";
    }

    @GetMapping("/editar/{id}")
    public String editarSala(@PathVariable Long id, Model model) {
        Sala sala = salaService.getIdSala(id);
        model.addAttribute("sala", sala);
        model.addAttribute("listaSala", salaService.listarSala());
        return "salas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarSala(@PathVariable Long id) {
        salaService.eliminarSala(id);
        return "redirect:/salas";
    }
}

