package com.taller.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ingrese el número de factura")
    private String numeroFactura;

    @NotNull(message = "Ingrese el precio del vehículo vendido")
    private Double precio;

    @NotNull(message = "Ingrese la fecha de venta")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @NotBlank(message = "Ingrese la observación de la venta")
    private String observaciones;


    @ManyToOne
    @NotNull(message = "Escoja el vendedor")
    @JoinColumn(name="id_empleado")
    private Empleado empleado;

    @ManyToOne
    @NotNull(message = "Elija el vehículo vendido")
    @JoinColumn(name="id_carros")
    private Carros carros;
}
