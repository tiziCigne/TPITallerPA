package com.app.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Modelo;
import com.app.web.repository.ModeloRepositorio;

@Service
public class ModeloServicioImpl implements ModeloServicio {

	@Autowired
	private ModeloRepositorio repositorio;

	@Override
	public List<Modelo> listarTodosLosModelos() {
		return repositorio.findAll();
	}

	@Override
	public Modelo guardarModelo(Modelo modelo) {
		return repositorio.save(modelo);
	}

	@Override
	public Modelo obtenerModeloPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Modelo actulizarModelo(Modelo modelo) {
		return repositorio.save(modelo);
	}

	@Override
	public void eliminarModelo(Long id) {
		repositorio.deleteById(id);
		
	}

	

}
