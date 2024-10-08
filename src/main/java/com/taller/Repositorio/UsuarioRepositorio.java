package com.taller.Repositorio;

import com.taller.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    @Query("SELECT u from Usuario u WHERE u.email=:email")
    public Usuario buscarUsuarioByEmail(@Param("email") String email);
}
