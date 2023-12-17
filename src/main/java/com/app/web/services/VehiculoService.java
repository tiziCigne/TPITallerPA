package com.app.web.services;

import java.util.List;


import com.app.web.entidad.Vehiculo;

public interface VehiculoService {

	public List<Vehiculo> listarTodosLosVehiculos();
	
	public Vehiculo guardarVehiculo(Vehiculo vehiculo);
	
	public Vehiculo obtenerVehiculoPorID(Long id);
	
	public Vehiculo actualizarVehiculo(Vehiculo vehiculo);
	
	public void eliminarVehiculo(Long id);

	
}
