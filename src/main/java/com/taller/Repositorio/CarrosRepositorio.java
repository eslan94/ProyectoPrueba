package com.taller.Repositorio;

import com.taller.Entidad.Carros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrosRepositorio extends JpaRepository<Carros, Long> {
}
