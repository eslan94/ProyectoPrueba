package com.taller.Controlador;

import com.taller.Entidad.Carros;
import com.taller.Repositorio.CarrosRepositorio;
import com.taller.Servicio.CarrosServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ControladorCarros {

    @Autowired
    private CarrosRepositorio carrosRepositorio;

    @GetMapping("/index")
    public String mostrarCarros(Model model) {
        List<Carros> carros = carrosRepositorio.findAll();
        model.addAttribute("carros", carros);
        return "index";
    }

    @Autowired
    CarrosServicio carrosServicio;

    //Index
//    @GetMapping("/index")
//    public String mostrarIndex(Model model){
//        return "/index";
//    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/indexUser")
    public String mostrarIndex2(Model model){
        List<Carros> carros = carrosRepositorio.findAll();
        model.addAttribute("carros", carros);
        return "/indexUser";
    }

    //LEER
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/carros")
    public String mostrarProductos(Model model){
        List<Carros> carros = carrosServicio.listarCarros();
        model.addAttribute("carros", carros);
        return "/Producto/listaPrductos";
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/carrosUser")
    public String mostrarProductos2(Model model){
        List<Carros> carros = carrosServicio.listarCarros();
        model.addAttribute("carros", carros);
        return "/Producto/listaPrductos2";
    }

    //CREAR
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/formulario")
    public String formularioCarro(Model model){
        model.addAttribute("carros", new Carros());
        return "/Producto/formulario";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/guardar")
    public String crearCarro(@Valid @ModelAttribute Carros carros, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/Producto/formulario";
        }else{
            carrosServicio.guadarCarros(carros);
            return "redirect:/carros";
        }

    }


    //ACTUALIZAR
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public String actualizarCarro(@PathVariable Long id, Model model){
        Optional<Carros> carros = carrosServicio.buscarCarros(id);
        model.addAttribute("carros", carros);
        return "/Producto/formulario";
    }

    //ELIMINAR
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}")
    public String borrarCarros(@PathVariable Long id){
        carrosServicio.eliminarCarros(id);
        return "redirect:/carros";
    }


}
