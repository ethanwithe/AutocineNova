package com.autocinema.pe.Controller;


import com.autocinema.pe.entity.Funciones;
import com.autocinema.pe.service.FuncionesService;
import com.autocinema.pe.service.PeliculaService;
import com.autocinema.pe.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funciones")

public class FuncionesController {
	
	 @Autowired
	    private FuncionesService funcionesService;

	    @Autowired
	    private PeliculaService peliculaService;

	    @Autowired
	    private SalaService salaService;

	    @GetMapping
	    public String listarFunciones(Model model) {
	        model.addAttribute("listaFunciones", funcionesService.listarFunciones());
	        model.addAttribute("listaPelicula", peliculaService.listarPelicula());
	        model.addAttribute("listaSala", salaService.listarSala());
	        model.addAttribute("funciones", new Funciones());
	        return "funciones";
	    }

	    @PostMapping("/guardar")
	    public String guardarFunciones(@ModelAttribute Funciones funciones) {
	        funcionesService.crearActualizarFunciones(funciones);
	        return "redirect:/funciones";
	    }

	    @GetMapping("/editar/{id}")
	    public String editarFunciones(@PathVariable Long id, Model model) {
	        model.addAttribute("funciones", funcionesService.getIdFunciones(id));
	        model.addAttribute("listaFunciones", funcionesService.listarFunciones());
	        model.addAttribute("listaPelicula", peliculaService.listarPelicula());
	        model.addAttribute("listaSala", salaService.listarSala());
	        return "funciones";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminarFunciones(@PathVariable Long id) {
	        funcionesService.eliminarFunciones(id);
	        return "redirect:/funciones";
	    }
	}