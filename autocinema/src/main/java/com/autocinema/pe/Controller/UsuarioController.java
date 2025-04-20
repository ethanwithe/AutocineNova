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
import com.autocinema.pe.entity.Usuario;
import com.autocinema.pe.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	 @Autowired
	    private UsuarioService usuarioService;

	    // Mostrar lista y formulario
	    @GetMapping
	    public String listarUsuario(Model model) {
	        List<Usuario> lista = usuarioService.listarUsuario();
	        model.addAttribute("listaUsuario", lista); 
	        model.addAttribute("usuario", new Usuario()); 
	        return "usuarios"; 
	    }

	    // Guardar o actualizar usuario
	    @PostMapping("/guardar")
	    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
	        usuarioService.crearActualizarUsuario(usuario);
	        return "redirect:/usuarios";
	    }

	    // Cargar datos en formulario para editar
	    @GetMapping("/editar/{id}")
	    public String editarUsuario(@PathVariable Long id, Model model) {
	        Usuario usuario = usuarioService.getIdUsuario(id);
	        model.addAttribute("usuario", usuario);
	        model.addAttribute("listaUsuario", usuarioService.listarUsuario());
	        return "usuarios";
	    }

	    // Eliminar usuario
	    @GetMapping("/eliminar/{id}")
	    public String eliminarUsuario(@PathVariable Long id) {
	        usuarioService.eliminarUsuario(id);
	        return "redirect:/usuarios";
	    }
	}