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

import com.autocinema.pe.entity.Funciones;
import com.autocinema.pe.service.FuncionesService;
import com.autocinema.pe.service.PeliculaService;
import com.autocinema.pe.service.SalaService;

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
        List<Funciones> lista = funcionesService.listarFunciones();
        model.addAttribute("listaFunciones", lista);
        model.addAttribute("funcion", new Funciones());
        
        model.addAttribute("peliculas", peliculaService.listarPelicula());
        model.addAttribute("salas", salaService.listarSala());
        return "funciones";
    }

    @PostMapping("/guardar")
    public String guardarFuncion(@ModelAttribute Funciones funcion) {
        funcionesService.crearActualizarFunciones(funcion);
        return "redirect:/funciones";
    }

    @GetMapping("/editar/{id}")
    public String editarFuncion(@PathVariable Long id, Model model) {
        Funciones funcion = funcionesService.getIdFunciones(id);
        model.addAttribute("funcion", funcion);
        model.addAttribute("listaFunciones", funcionesService.listarFunciones());
        
        model.addAttribute("peliculas", peliculaService.listarPelicula());
        model.addAttribute("salas", salaService.listarSala());
        return "funciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarFuncion(@PathVariable Long id) {
        funcionesService.eliminarFunciones(id);
        return "redirect:/funciones";
    }

}
