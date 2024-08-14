package com.taller.Controlador;

import com.taller.Entidad.Carros;
import com.taller.Entidad.Empleado;
import com.taller.Servicio.EmpleadoServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ControladorEmpleado {
    @Autowired
    EmpleadoServicio empleadoServicio;

    //LEER
    @GetMapping("/empleado")
    public String mostrarEmpleado(Model model){
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        model.addAttribute("empleado", empleados);
        return "/Empleado/vistaEmpleado";
    }

    //CREAR
    @GetMapping("/formularioEmpleado")
    public String formularioEmpleado(Model model){
        model.addAttribute("empleado", new Empleado());
        return "/Empleado/formularioEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String crearEmpleado(@Valid @ModelAttribute Empleado empleado, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/Empleado/formularioEmpleado";
        }else{
            empleadoServicio.guadarEmpleados(empleado);
            return "redirect:/empleado";
        }

    }

    //ACTUALIZAR
    @GetMapping("/editarEmpleado/{id}")
    public String actualizarEmpleado(@PathVariable Long id, Model model){
        Optional<Empleado> empleado = empleadoServicio.buscarEmpleado(id);
        model.addAttribute("empleado", empleado);
        return "/Empleado/formularioEmpleado";
    }

    //ELIMINAR
    @GetMapping("/eliminarEmpleado/{id}")
    public String borrarEmpleado(@PathVariable Long id){
        empleadoServicio.eliminarEmpleado(id);
        return "redirect:/empleado";
    }

}
