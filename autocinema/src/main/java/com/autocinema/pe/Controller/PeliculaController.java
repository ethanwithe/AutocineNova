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

import com.autocinema.pe.entity.Pelicula;
import com.autocinema.pe.service.PeliculaService;



@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
	
	@Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String listarPeliculas(Model model) {
        List<Pelicula> lista = peliculaService.listarPelicula();
        model.addAttribute("listaPeliculas", lista);
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.crearActualizarPelicula(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Long id, Model model) {
        Pelicula pelicula = peliculaService.getIdPelicula(id);
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("listaPeliculas", peliculaService.listarPelicula());
        return "peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }

}
