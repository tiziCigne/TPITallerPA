package com.app.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.web.entidad.OrdenTrabajo;

public interface OrdenTrabajoRepositorio extends JpaRepository<OrdenTrabajo, Long> {

    @Query("SELECT ot FROM OrdenTrabajo ot " +
            "WHERE (:fecha IS NULL OR ot.fechaCreacion = :fecha)")
    List<OrdenTrabajo> filtrarOrdenesPorFecha(@Param("fecha") Date fecha);

}


