package com.taller.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "EL nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "EL apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "EL telefono es obligatorio")
    private String telefono;

    @NotBlank(message = "EL correo es obligatorio")
    private String email;

    @OneToMany(mappedBy = "empleado")
    private List<Factura> facturas;

}
