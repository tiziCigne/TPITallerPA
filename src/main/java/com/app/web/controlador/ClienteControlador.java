package com.app.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.web.entidad.Cliente;
import com.app.web.services.ClienteServicio;

import jakarta.annotation.Resource;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

@Configuration
@Controller
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;
	


	// Maneja solicitudes GET para listar todos los clientes.
	@GetMapping("/clientes")
	public String listarClientes(Model modelo) { // Llama al servicio para obtener todos los clientes
		modelo.addAttribute("clientes",servicio.listarTodosLosClientes());
												// Devuelve la vista "clientes" que mostrará la lista de clientes.
		return "clientes"; //nos retorna al archivo 
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
	    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente,
	                                @RequestParam("archivo") MultipartFile archivo) {
		  if (!archivo.isEmpty()) {
		        try {
		            byte[] archivoBytes = archivo.getBytes();
		            // Aquí deberías procesar el archivo como desees y guardarlo
		            // También, asegúrate de que el nombre del archivo se esté estableciendo correctamente
		            cliente.setCliente(archivo.getOriginalFilename());
		        } catch (IOException e) {
		            e.printStackTrace();
		            // Manejar errores relacionados con la carga del archivo
		        }
		    }

	        // Llama al servicio para guardar el nuevo cliente en la base de datos.
	        servicio.guardarCliente(cliente);
	        // Redirige al usuario de nuevo a la lista de clientes después de guardar.
	        return "redirect:/clientes";
	    }
		
		
	 // Maneja solicitudes GET para mostrar el formulario de edición de cliente.
	@GetMapping("/clientes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo){
		 // Llama al servicio para obtener el cliente con el ID especificado.
		modelo.addAttribute("cliente", servicio.obtenerClientePorId(id));
		 // Devuelve la vista "editar_cliente" que contiene el formulario de edición.
		return "editar_cliente";
	}
	 // Maneja solicitudes POST para actualizar un cliente existente.
	@PostMapping("/clientes/{id}")
	public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente")Cliente cliente){
		// Llama al servicio para obtener el cliente existente con el ID especificado.
		Cliente clienteExistente = servicio.obtenerClientePorId(id);
		// Actualiza los datos del cliente existente con los datos del formulario.
		clienteExistente.setId(id);
		clienteExistente.setNombre(cliente.getNombre());
		clienteExistente.setApellido(cliente.getApellido());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setTelefono(cliente.getTelefono());
		clienteExistente.setDireccion(cliente.getDireccion());
		clienteExistente.setInformacion(cliente.getInformacion());

		// Llama al servicio para actualizar el cliente en la base de datos.
		servicio.actualizarCliente(clienteExistente);
		// Redirige al usuario de nuevo a la lista de clientes después de actualizar.
		return "redirect:/clientes";
		
	}
	// Maneja solicitudes GET para buscar clientes por palabra clave.
	@GetMapping("/clientes/buscar")
	public String buscarClientesPorPalabraClave(@Param("palabraClave") String palabraClave, Model modelo) {
		List<Cliente> listaClientes = servicio.listAll(palabraClave);
	    modelo.addAttribute("clientes", listaClientes);
	    modelo.addAttribute("palabraClave", palabraClave);
	    return "clientes";
	}
	
	@GetMapping("/archivos/{nombreArchivo}")
	public ResponseEntity<Resource> servirArchivo(@PathVariable String nombreArchivo) {
	    Resource archivo = servicio.obtenerArchivo(nombreArchivo);

	    // Obtener el tipo de contenido basado en el nombre del archivo (puedes ajustar esto según los tipos de archivos que manejes)
	    String contentType = "application/octet-stream"; // Por defecto, se establece como binario

	    // Si el archivo es una imagen, ajusta el tipo de contenido
	    if (nombreArchivo != null && (nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".jpeg") || nombreArchivo.endsWith(".png"))) {
	        contentType = "image/jpeg"; // Puedes ajustar según el tipo de imagen
	    }

	    // Devuelve la imagen como recurso directamente con el tipo de contenido
	    return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_TYPE, contentType)
	            .body(archivo);
	}

	
	@GetMapping("/clientes/mostrar-archivo/{id}")
	public String mostrarArchivo(@PathVariable Long id, Model modelo) {
	    // Lógica para cargar la información del cliente con el ID proporcionado
	    Cliente cliente = servicio.obtenerClientePorId(id);

	    // Asegúrate de que el nombre del archivo esté configurado correctamente en el objeto cliente
	    System.out.println("Nombre del archivo: " + cliente.getCliente());

	    modelo.addAttribute("cliente", cliente);
	    return "mostrar_archivo_cliente";
	}


	@Configuration
	public class WebConfig implements WebMvcConfigurer {
	    @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/archivos/**").addResourceLocations("C:\\Users\\alvar\\Desktop\\ImagenesTP");
	    }
	}
	
	
}