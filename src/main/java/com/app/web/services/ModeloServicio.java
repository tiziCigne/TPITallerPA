package com.app.web.services;

import java.util.List;
import com.app.web.entidad.Modelo;

public interface ModeloServicio {

		public List<Modelo> listarTodosLosModelos();
		
		public Modelo guardarModelo(Modelo modelo);
		
		public Modelo obtenerModeloPorId(Long id);
		
		public Modelo actulizarModelo(Modelo modelo);
		
		public void eliminarModelo(Long id);
		
		
		
}
