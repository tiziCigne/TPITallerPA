package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Marca;
import com.app.web.services.MarcaService;

@Controller
public class MarcaControlador {

	@Autowired
	private MarcaService servicio;

	@GetMapping("/marcas")
	public String listarMarcas(Model modelo) {
		modelo.addAttribute("marcas", servicio.listarTodasLasMarcas());
		return "marcas"; // Nos retorna al archivo marcas
	}

	@GetMapping("/marcas/new")
	public String mostrarFormularioRegistroMarca(Model modelo) {
		Marca marca = new Marca();
		modelo.addAttribute("marca", marca);
		return "crear_marca";
	}

	@PostMapping("/marcas")
	public String guardarMarca(@ModelAttribute("marca") Marca marca) {
		servicio.guardarMarca(marca);
		return "redirect:/marcas";
	}

	@GetMapping("/marcas/editar/{id}")
	public String mostrarFormEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("marca", servicio.obtenerMarcaPorID(id));
		return "editar_marcas";
	}

	@PostMapping("/marcas/{id}")
	public String actualizarMarca(@PathVariable Long id, @ModelAttribute("marca") Marca marca, Model modelo) {
		Marca marcaExistente = servicio.obtenerMarcaPorID(id);
		marcaExistente.setId(id);
		marcaExistente.setNombre(marca.getNombre());

		servicio.actualizarMarca(marcaExistente);
		return "redirect:/marcas";
	}

	@GetMapping("/marcas/{id}")
	public String eliminarMarca(@PathVariable Long id) {
		servicio.eliminarMarca(id);
		return "redirect:/marcas";
	}
}