package com.app.web.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.repository.ClienteRepositorio;
import com.app.web.entidad.Cliente;

@Service
public class ClienteServicioIMPL implements ClienteServicio {

    @Autowired
    private ClienteRepositorio repositorioCliente;

    @Override
    public List<Cliente> listarTodosLosClientes() {
        return repositorioCliente.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return repositorioCliente.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return repositorioCliente.findById(id).orElse(null);	
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return repositorioCliente.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        repositorioCliente.deleteById(id);
    }


	@Override
	public List<Cliente> listAll(String palabraClave) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Cliente> findByClienteContainingIgnoreCase(
	        String nombre, String id, String apellido, String email, String telefono, 
	        String direccion, String informacion, Date fechaCreacionOrden) {
	    return repositorioCliente.findByClienteContainingIgnoreCase(
	        nombre, id, apellido, email, telefono, direccion, informacion, fechaCreacionOrden);
	}




}
