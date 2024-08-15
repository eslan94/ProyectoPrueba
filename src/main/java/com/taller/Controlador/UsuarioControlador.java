package com.taller.Controlador;

import com.taller.Entidad.Usuario;
import com.taller.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostMapping("/registro")
    public String registroUsuario(@RequestParam String nombre, @RequestParam String email, @RequestParam String password, Model model) {
        try {
            usuarioServicio.registrarUsuario(nombre, email, password);
            model.addAttribute("exito", "Usuario registrado");
            return "Usuario/cuenta";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "usuario";
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicioSesion")
    public String inicioSesion(){
        return "indexUser";
    }

    @GetMapping("/logout")
    public String cerrarSesion(){
        return "Usuario/cuenta";
    }


}
