package com.taller.Controlador;

import com.taller.Entidad.Usuario;
import com.taller.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    //LEER
    @GetMapping("/usuario")
    public String mostrarUsuarios(Model model){
        List<Usuario> usuarios = usuarioServicio.listarUsuario();
        model.addAttribute("usuario", usuarios);
        return "/Usuario/listarUsuario";
    }

    //CREAR
    @GetMapping("/formularioUsuario")
    public String formularioUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/Usuario/formularioUsuario";
    }


}
