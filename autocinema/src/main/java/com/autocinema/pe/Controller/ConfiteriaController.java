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

import com.autocinema.pe.entity.Confiteria;
import com.autocinema.pe.service.ConfiteriaService;

@Controller
@RequestMapping("/confiterias")
public class ConfiteriaController {
	
	@Autowired
    private ConfiteriaService confiteriaService;

    @GetMapping
    public String listarConfiterias(Model model) {
        List<Confiteria> lista = confiteriaService.listarConfiteria();
        model.addAttribute("listaConfiterias", lista);
        model.addAttribute("confiteria", new Confiteria());
        return "confiterias";                                            
    }

    @PostMapping("/guardar")
    public String guardarConfiteria(@ModelAttribute Confiteria confiteria) {
        confiteriaService.crearActualizarConfiteria(confiteria);
        return "redirect:/confiterias";
    }

    @GetMapping("/editar/{id}")
    public String editarConfiteria(@PathVariable Long id, Model model) {
        Confiteria confiteria = confiteriaService.getIdConfiteria(id);
        model.addAttribute("confiteria", confiteria);
        model.addAttribute("listaConfiterias", confiteriaService.listarConfiteria());
        return "confiterias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarConfiteria(@PathVariable Long id) {
        confiteriaService.eliminarConfiteria(id);
        return "redirect:/confiterias";
    }

}
