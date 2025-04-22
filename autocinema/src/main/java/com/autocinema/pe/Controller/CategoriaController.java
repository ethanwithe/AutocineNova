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

import com.autocinema.pe.entity.Categoria;
import com.autocinema.pe.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategoria(Model model) {
        List<Categoria> lista = categoriaService.listarCategoria();
        model.addAttribute("listaCategoria", lista);
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    // Guarda o actualiza la categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.crearActualizarCategoria(categoria);
        return "redirect:/categorias";
    }

    // Editar: carga la categoría en el formulario
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getIdCategoria(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategoria", categoriaService.listarCategoria());
        return "categorias";
    }

    // Eliminar categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }
}