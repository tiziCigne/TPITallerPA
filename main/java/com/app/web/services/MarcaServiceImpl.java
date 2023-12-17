package com.app.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Marca;
import com.app.web.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaRepository repositorio;
	
	@Override
	public List<Marca> listarTodasLasMarcas() {
		return repositorio.findAll();
	}

	@Override
	public Marca guardarMarca(Marca marca) {
		return repositorio.save(marca);
	}

	@Override
	public Marca obtenerMarcaPorID(Long id) {
		return repositorio.findById(id).get();
	}
	
	@Override
	public Marca actualizarMarca(Marca marca) {
		return repositorio.save(marca);
	}

	@Override
	public void eliminarMarca(Long id) {
		repositorio.deleteById(id);
	}
}