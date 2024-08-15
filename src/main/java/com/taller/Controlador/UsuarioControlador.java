package com.taller.Controlador;

import com.taller.Entidad.Empleado;
import com.taller.Entidad.Usuario;
import com.taller.Servicio.UsuarioServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.relation.Role;
import java.util.List;

@Controller
public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ControladorCarros controladorCarros;



    @PostMapping("/registro")
    public String registroUsuario(@RequestParam String nombre, @RequestParam String email, @RequestParam String password, Model model) {
        try {
            usuarioServicio.registrarUsuario(nombre, email, password);
            model.addAttribute("exito", "Usuario registrado");
            return "Usuario/cuenta";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }


//    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
//    @GetMapping("/inicioSesion")
//    public String inicioSesion(){
//        String role="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')";
//        if (role.equals("ROLE_ADMIN")) {
//            return "index";
//        } else if (role.equals("ROLE_USER")) {
//            return "indexUser";
//        }
//        return "role";
//    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicioSesion")
    public String inicioSesion() {
        // Obtener la autenticación del contexto de seguridad
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificar si el usuario tiene el rol de ADMIN
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "/Admin/AdminCarros";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "indexUser";
        }

        // En caso de que no tenga ninguno de los roles esperados, redirigir a una página predeterminada
        return "indexUser";
}




    @GetMapping("/logout")
    public String cerrarSesion(){
        return "Usuario/cuenta";
    }


}
