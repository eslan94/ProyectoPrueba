package com.taller.Servicio;

import com.taller.Entidad.Empleado;
import com.taller.Repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicio {

    @Autowired
    EmpleadoRepositorio empleadoRepositorio;

    public List<Empleado> listarEmpleados(){
        return empleadoRepositorio.findAll();
    }
    public Optional<Empleado> buscarEmpleado(Long id){
        return empleadoRepositorio.findById(id);
    }
    public  void  guadarEmpleados(Empleado empleado){
        empleadoRepositorio.save(empleado);
    }
    public void eliminarEmpleado(Long id){
        empleadoRepositorio.deleteById(id);
    }

}
