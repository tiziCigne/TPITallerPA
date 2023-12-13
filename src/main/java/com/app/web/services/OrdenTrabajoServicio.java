package com.app.web.services;

import java.util.Date;
import java.util.List;

import com.app.web.entidad.OrdenTrabajo;

public interface OrdenTrabajoServicio {
    List<OrdenTrabajo> listarTodosLosOrdenesTrabajo();
    OrdenTrabajo guardarOrdenTrabajo(OrdenTrabajo ordenTrabajo);
    OrdenTrabajo obtenerOrdenTrabajoPorID(Long id);
    OrdenTrabajo actualizarOrdenTrabajo(OrdenTrabajo ordenTrabajo);
    void eliminarOrdenTrabajo(Long id);
    List<OrdenTrabajo> filtrarOrdenesPorFecha(Date fecha);


}
