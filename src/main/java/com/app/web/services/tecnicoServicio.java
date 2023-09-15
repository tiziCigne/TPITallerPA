package com.app.web.services;

import java.util.List;

import com.app.web.entidad.tecnico;

public interface tecnicoServicio {

	public List<tecnico> listarTodosLosTecnicos();
	
	public tecnico guardarTecnico(tecnico tecnico);
	
	public tecnico obtenerTecnicoPorID(long id);
	
	public tecnico actualizarTecnico(tecnico tecnico);
	
	public void eliminarTecnico(long id);
	
	
	
	
	;
}
