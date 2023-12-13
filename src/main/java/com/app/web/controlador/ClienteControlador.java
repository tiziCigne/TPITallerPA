package com.app.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entidad.Cliente;
import com.app.web.entidad.OrdenTrabajo;
import com.app.web.services.ClienteServicio;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;

    @GetMapping("/clientes")
    public String listarClientes(Model modelo) {
        List<Cliente> clientes = servicio.listarTodosLosClientes();

        for (Cliente cliente : clientes) {
            if (cliente.getOrdenesDeTrabajo() != null && !cliente.getOrdenesDeTrabajo().isEmpty()) {
                cliente.getOrdenesDeTrabajo().sort(Comparator.comparing(OrdenTrabajo::getFechaCreacion).reversed());
                Date fechaCreacionOrden = cliente.getOrdenesDeTrabajo().get(0).getFechaCreacion();
                cliente.actualizarFechaCreacionOrden(fechaCreacionOrden);
            }
        }

        modelo.addAttribute("clientes", clientes);
        return "clientes";
    }

    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeRegistroDeCliente(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "crear_cliente";
    }

    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        servicio.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("cliente", servicio.obtenerClientePorId(id));
        return "editar_cliente";
    }

    @PostMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
        Cliente clienteExistente = servicio.obtenerClientePorId(id);
        clienteExistente.setId(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellido(cliente.getApellido());
        clienteExistente.setEmail(cliente.getEmail());
        servicio.actualizarCliente(clienteExistente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/buscar")
    public String buscarClientesPorFiltros(
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "id", required = false) String id,
            @RequestParam(name = "apellido", required = false) String apellido,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "telefono", required = false) String telefono,
            @RequestParam(name = "direccion", required = false) String direccion,
            @RequestParam(name = "informacion", required = false) String informacion,
            @RequestParam(name = "fechaCreacionOrden", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCreacionOrden,
            Model modelo) {

        System.out.println("Fecha recibida en el controlador (OrdenTrabajo): " + fechaCreacionOrden);

        List<Cliente> listaClientes = servicio.findByClienteContainingIgnoreCase(
                nombre, id, apellido, email, telefono, direccion, informacion, fechaCreacionOrden);

        modelo.addAttribute("clientes", listaClientes);
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("id", id);
        modelo.addAttribute("apellido", apellido);
        modelo.addAttribute("email", email);
        modelo.addAttribute("telefono", telefono);
        modelo.addAttribute("direccion", direccion);
        modelo.addAttribute("informacion", informacion);
        modelo.addAttribute("fechaCreacionOrden", fechaCreacionOrden);

        return "clientes";
    }



    @GetMapping("/clientes/limpiarFiltros")
    public String limpiarFiltros(Model modelo) {
        // Redirect to the main clients page without filtering
        return "redirect:/clientes";
    }

    
    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        servicio.eliminarCliente(id);
        return "redirect:/clientes";
    }

}
