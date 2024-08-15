package com.taller.Entidad;

import com.taller.Roles.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank(message = "Ingrese su nombre")
    private String nombre;

    //@NotBlank(message = "Ingrese un correo electrónico")
    private String email;

    //@NotBlank(message = "La contraseña es obligatoria")
    private String password;

    //@Enumerated(EnumType.STRING)
    private Rol rol;
}

