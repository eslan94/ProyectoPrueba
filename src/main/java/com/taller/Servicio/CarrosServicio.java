package com.taller.Servicio;

import com.taller.Entidad.Carros;
import com.taller.Repositorio.CarrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrosServicio {

    @Autowired
    CarrosRepositorio carrosRepositorio;

    public List<Carros> listarCarros(){
        return carrosRepositorio.findAll();
    }
    public Optional<Carros> buscarCarros(Long id){
        return carrosRepositorio.findById(id);
    }
    public  void  guadarCarros(Carros carros){
        carrosRepositorio.save(carros);
    }
    public void eliminarCarros(Long id){
        carrosRepositorio.deleteById(id);
    }


}
