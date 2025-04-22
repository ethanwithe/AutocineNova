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

import com.autocinema.pe.entity.Sede;
import com.autocinema.pe.service.SedeService;

@Controller
@RequestMapping("/sedes")

public class SedeController {

	 @Autowired
	    private SedeService sedeService;

	    @GetMapping
	    public String listarSede(Model model) {
	        List<Sede> listaSede = sedeService.listarSede();
	        model.addAttribute("listaSede", listaSede);
	        model.addAttribute("sede", new Sede());
	        return "sedes";
	    }

	    @PostMapping("/guardar")
	    public String guardarSede(@ModelAttribute Sede sede) {
	        sedeService.crearActualizarSede(sede);
	        return "redirect:/sedes";
	    }

	    @GetMapping("/editar/{id}")
	    public String editarSede(@PathVariable Long id, Model model) {
	        Sede sede = sedeService.getIdSede(id);
	        model.addAttribute("sede", sede);
	        model.addAttribute("listaSede", sedeService.listarSede());
	        return "sedes";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminarSede(@PathVariable Long id) {
	        sedeService.eliminarSede(id);
	        return "redirect:/sedes";
	    }
	}
