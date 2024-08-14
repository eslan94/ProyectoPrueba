package com.taller.Servicio;

import com.taller.Entidad.Carros;
import com.taller.Entidad.Factura;
import com.taller.Repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturaServicio {

    @Autowired
    FacturaRepositorio facturaRepositorio;

    public List<Carros> buscarCarrosPorFactura(String numeroFactura){
        return facturaRepositorio.findByNumeroFactura(numeroFactura).stream()
                .map(Factura::getCarros)
                .collect(Collectors.toList());
    }
    public void guardarFactura(Factura factura) {
        facturaRepositorio.save(factura);
    }

    public List<Factura> buscarFacturasPorNumero(String numeroFactura) {
        return facturaRepositorio.findByNumeroFactura(numeroFactura);
    }

    public List<Factura> obtenerTodasLasFacturas() {
        return facturaRepositorio.findAll();
    }
}
