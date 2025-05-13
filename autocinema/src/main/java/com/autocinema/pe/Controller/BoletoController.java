package com.autocinema.pe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocinema.pe.entity.Boleto;
import com.autocinema.pe.service.BoletoService;

@Controller
@RequestMapping("/boletos")
public class BoletoController {
	
	@Autowired
    private BoletoService boletoService;

    @GetMapping
    public String listarBoletos(Model model) {
        model.addAttribute("listaBoletos", boletoService.listarBoletos());
        model.addAttribute("boleto", new Boleto());
        return "boletos";
    }

    @PostMapping("/guardar")
    public String guardarBoleto(@ModelAttribute Boleto boleto) {
        boletoService.guardar(boleto);
        return "redirect:/boletos";
    }

    @GetMapping("/editar/{id}")
    public String editarBoleto(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boleto", boletoService.buscarPorId(id));
        model.addAttribute("listaBoletos", boletoService.listarBoletos());
        return "boletos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarBoleto(@PathVariable("id") Long id) {
        boletoService.eliminarBoletos(id);
        return "redirect:/boletos";
    }
	
}
