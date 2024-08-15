package com.taller.Controlador;

import com.taller.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, Model model){
        if (error!=null){
            model.addAttribute("error", "Usuario o Contraseña Invalida");
        }
        return "Usuario/cuenta";
    }


}
