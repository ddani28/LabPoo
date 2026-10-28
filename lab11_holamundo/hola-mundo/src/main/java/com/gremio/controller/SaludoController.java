package com.gremio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gremio.model.Aventurero;

@Controller
public class SaludoController {

    @GetMapping("/saludo")
    public String saludo(Model model) {
        // Preparación de los datos para la vista
        final String mensaje = "¡Hola Mundo desde Spring Boot!";
        final String gremio = "Gran Gremio de Aventureros";
        final int nivel = 1;

        // Envío de los datos a la vista
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("gremio", gremio);
        model.addAttribute("nivel", nivel);

        return "saludo"; // busca templates/saludo.html
    }

    @GetMapping("/aventurero")
    public String aventurero(Model model) {
        Aventurero aventurero = new Aventurero("Sylva", "Druida", 10);
        model.addAttribute("aventurero", aventurero);
        return "aventurero";
    }
}