package com.app.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entidad.Cliente;
import com.app.web.services.ClienteServicio;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ClienteControlador {

    @Autowired
    private ClienteServicio servicio;

    // Maneja solicitudes GET para listar todos los clientes.
    @GetMapping("/clientes")
    public String listarClientes(Model modelo) {
        // Llama al servicio para obtener todos los clientes
        modelo.addAttribute("clientes", servicio.listarTodosLosClientes());
        // Devuelve la vista "clientes" que mostrará la lista de clientes.
        return "clientes";
    }

    // Maneja solicitudes GET para mostrar el formulario de registro de cliente.
    @GetMapping("/clientes/nuevo")
    public String mostrarFormularioDeRegistroDeCliente(Model modelo) {
        // Crea un nuevo objeto Cliente.
        Cliente cliente = new Cliente();
        // Agrega el objeto cliente al modelo para ser utilizado en la vista.
        modelo.addAttribute("cliente", cliente);
        // Devuelve la vista "crear_cliente" que contiene el formulario de registro.
        return "crear_cliente";
    }

    // Maneja solicitudes POST para guardar un nuevo cliente.
    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente, @RequestParam("password") String password, Model modelo) {
        // Aquí debes realizar la validación de la contraseña
        if (password != null && password.equals("1234")) {
            // La contraseña es correcta, puedes guardar al cliente
            servicio.guardarCliente(cliente);
            return "redirect:/clientes";
        } else {
            // La contraseña es incorrecta, muestra un mensaje de error
            modelo.addAttribute("error", "Contraseña incorrecta");
            return "crear_cliente"; // Vuelve a la página de creación de cliente con un mensaje de error
        }
    }

    // Maneja solicitudes GET para mostrar el formulario de edición de cliente.
    @GetMapping("/clientes/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
        // Llama al servicio para obtener el cliente con el ID especificado.
        Cliente cliente = servicio.obtenerClientePorId(id);
        if (cliente != null) {
            modelo.addAttribute("cliente", cliente);
            return "editar_cliente";
        } else {
            // Si no se encuentra el cliente, redirige a la lista de clientes
            return "redirect:/clientes";
        }
    }

    // Maneja solicitudes POST para actualizar un cliente existente.
    @PostMapping("/clientes/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente,
            @RequestParam("password") String password, Model modelo) {
        // Aquí debes realizar la validación de la contraseña para editar
        if (password != null && password.equals("1234")) {
            // La contraseña es correcta, puedes actualizar al cliente
            Cliente clienteExistente = servicio.obtenerClientePorId(id);
            if (clienteExistente != null) {
                // Actualiza los datos del cliente existente con los datos del formulario.
                clienteExistente.setId(id);
                clienteExistente.setNombre(cliente.getNombre());
                clienteExistente.setApellido(cliente.getApellido());
                clienteExistente.setEmail(cliente.getEmail());
                // Llama al servicio para actualizar el cliente en la base de datos.
                servicio.actualizarCliente(clienteExistente);
                // Redirige al usuario de nuevo a la lista de clientes después de actualizar.
                return "redirect:/clientes";
            } else {
                // Cliente no encontrado, muestra un mensaje de error
                modelo.addAttribute("error", "Cliente no encontrado");
                return "editar_cliente"; // Vuelve a la página de edición de cliente con un mensaje de error
            }
        } else {
            // La contraseña es incorrecta, muestra un mensaje de error
            modelo.addAttribute("error", "Contraseña incorrecta");
            // Vuelve a la página de edición de cliente con un mensaje de error
            modelo.addAttribute("cliente", cliente);
            return "editar_cliente";
        }
    }

    // Maneja solicitudes GET para eliminar un cliente.
    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        // Llama al servicio para eliminar el cliente con el ID especificado.
        servicio.eliminarCliente(id);
        // Redirige al usuario de nuevo a la lista de clientes después de eliminar.
        return "redirect:/clientes";
    }
}