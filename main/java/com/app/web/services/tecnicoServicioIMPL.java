package com.app.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.tecnico;
import com.app.web.repository.tecnicoRepositorio;

@Service
public class tecnicoServicioIMPL implements tecnicoServicio {

	@Autowired
	private tecnicoRepositorio repositorioTecnico;

	@Override
	public List<tecnico> listarTodosLosTecnicos() {
		// TODO Auto-generated method stub
		return repositorioTecnico.findAll();
	}

	@Override
	public tecnico guardarTecnico(tecnico tecnico) {
		return repositorioTecnico.save(tecnico);
	}

	@Override
	public tecnico obtenerTecnicoPorID(long id) {
		return repositorioTecnico.findById(id).get();
	}

	@Override
	public tecnico actualizarTecnico(tecnico tecnico) {
		return repositorioTecnico.save(tecnico);
	}

	@Override
	public void eliminarTecnico(long id) {
		repositorioTecnico.deleteById(id);
	}

}


	


