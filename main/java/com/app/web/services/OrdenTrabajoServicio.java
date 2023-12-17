package com.app.web.services;

import java.util.List;

import com.app.web.entidad.OrdenTrabajo; // Cambio Vehiculo por OrdenTrabajo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrdenTrabajoServicio {

    public List<OrdenTrabajo> listarTodosLosOrdenesTrabajo(); // Cambio Vehiculo por OrdenTrabajo

    public OrdenTrabajo guardarOrdenTrabajo(OrdenTrabajo ordenTrabajo); // Cambio Vehiculo por OrdenTrabajo

    public OrdenTrabajo obtenerOrdenTrabajoPorID(Long id); // Cambio Vehiculo por OrdenTrabajo

    public OrdenTrabajo actualizarOrdenTrabajo(OrdenTrabajo ordenTrabajo); // Cambio Vehiculo por OrdenTrabajo

    public void eliminarOrdenTrabajo(Long id);

   
    }
