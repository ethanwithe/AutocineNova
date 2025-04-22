package com.autocinema.pe.Controller;


import com.autocinema.pe.entity.MetodoPago;
import com.autocinema.pe.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/metodos_pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public String listarMetodosPago(Model model) {
        model.addAttribute("listaMetodos", metodoPagoService.listarMetodoPago());
        model.addAttribute("nuevoMetodo", new MetodoPago());
        return "metodos_pago";
    }

    @PostMapping("/guardar")
    public String guardarMetodoPago(@ModelAttribute("nuevoMetodo") MetodoPago metodo) {
        metodoPagoService.crearActualizarMetodoPago(metodo);
        return "redirect:/metodos_pago";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMetodo(@PathVariable Long id) {
        metodoPagoService.eliminarMetodoPago(id);
        return "redirect:/metodos_pago";
    }

    @GetMapping("/editar/{id}")
    public String editarMetodo(@PathVariable Long id, Model model) {
        MetodoPago metodo = metodoPagoService.getIdMetodoPago(id);
        model.addAttribute("nuevoMetodo", metodo);
        model.addAttribute("listaMetodos", metodoPagoService.listarMetodoPago());
        return "metodos_pago";
    }
}