package com.autocinema.pe.Controller;

import com.autocinema.pe.entity.Boletos;
import com.autocinema.pe.service.BoletosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boletos")
public class BoletosController {

    @Autowired
    private BoletosService boletosService;

    @GetMapping
    public String listarBoletos(Model model) {
        model.addAttribute("listaBoletos", boletosService.listarBoletos());
        model.addAttribute("boleto", new Boletos());
        return "boletos";
    }

    @PostMapping("/guardar")
    public String guardarBoleto(@ModelAttribute Boletos boleto) {
        boletosService.guardar(boleto);
        return "redirect:/boletos";
    }

    @GetMapping("/editar/{id}")
    public String editarBoleto(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boleto", boletosService.buscarPorId(id));
        model.addAttribute("listaBoletos", boletosService.listarBoletos());
        return "boletos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarBoleto(@PathVariable("id") Long id) {
        boletosService.eliminarBoletos(id);
        return "redirect:/boletos";
    }
}