package com.app.web.services;

import java.util.List;

import com.app.web.entidad.Marca;


public interface MarcaService {

    public List<Marca> listarTodasLasMarcas();

    public Marca guardarMarca(Marca marca);

    public Marca obtenerMarcaPorID(Long id);

    public Marca actualizarMarca(Marca marca);

    public void eliminarMarca(Long id);

}