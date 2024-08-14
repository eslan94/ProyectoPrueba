package com.taller.Controlador;

import com.taller.Entidad.Carros;
import com.taller.Entidad.Empleado;
import com.taller.Entidad.Factura;
import com.taller.Servicio.CarrosServicio;
import com.taller.Servicio.EmpleadoServicio;
import com.taller.Servicio.FacturaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorFactura {
    @Autowired
    FacturaServicio facturaServicio;
    @Autowired
    EmpleadoServicio empleadoServicio;
    @Autowired
    CarrosServicio carrosServicio;

//    @GetMapping("/facturas")
//    public String buscarProductosByFactura(@RequestParam(value = "numeroFactura", required= false) String numeroFactura, Model model){
//        if(numeroFactura!=null && !numeroFactura.isEmpty()){
//            List<Carros> carros=facturaServicio.buscarCarrosPorFactura(numeroFactura);
//            model.addAttribute("carros", carros);
//        }
//        return "Factura/vistaFactura";
//    }

    @GetMapping("/facturas")
    public String buscarFacturas(@RequestParam(value = "query", required = false) String query, Model model) {
        List<Factura> facturas;

        if (query != null && !query.isEmpty()) {
            // Buscar facturas por número de factura
            facturas = facturaServicio.buscarFacturasPorNumero(query);
        } else {
            // Obtener todas las facturas si no se proporciona un número de factura
            facturas = facturaServicio.obtenerTodasLasFacturas();
        }

        model.addAttribute("facturas", facturas);
        return "Factura/vistaFactura";
    }

    @GetMapping("/crearFactura")
    public String mostrarFormulario(Model model) {
        List<Empleado> empleados = empleadoServicio.listarEmpleados();
        List<Carros> carros = carrosServicio.listarCarros();
        model.addAttribute("empleados", empleados);
        model.addAttribute("carros", carros);
        model.addAttribute("factura", new Factura());
        return "Factura/formularioFactura";
    }

    @PostMapping("/guardarFactura")
    public String crearCarro(@Valid @ModelAttribute Factura factura, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/Factura/formularioFactura";
        }else{
            facturaServicio.guardarFactura(factura);
            return "redirect:/facturas";
        }

    }

}
