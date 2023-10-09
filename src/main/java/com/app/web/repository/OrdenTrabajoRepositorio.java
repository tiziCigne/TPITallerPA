package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.OrdenTrabajo; // Cambio Vehiculo por OrdenTrabajo

@Repository
public interface OrdenTrabajoRepositorio extends JpaRepository<OrdenTrabajo, Long> { // Cambio Vehiculo por OrdenTrabajo

}