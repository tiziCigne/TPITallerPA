package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.tecnico;
import com.app.web.services.tecnicoServicio;

@Controller
public class tecnicoControlador {

	@Autowired
	private tecnicoServicio servicio;

	@GetMapping("/tecnico")
	public String listarTecnico(Model modelo) {
		modelo.addAttribute("tecnico", servicio.listarTodosLosTecnicos());
		return "tecnico"; // nos retorna a tecnico

	}

	@GetMapping("/tecnico/registrar")
	public String MostrarFormularioParaRegistrarTecnico(Model modelo) {
		tecnico tecnico = new tecnico();
		modelo.addAttribute("tecnico", tecnico);
		return "registrar_tecnico";

	}

	@PostMapping("/tecnico")
	public String guardarTecnico(@ModelAttribute("tecnico") tecnico tecnico) {
		servicio.guardarTecnico(tecnico);
		return "redirect:/tecnico";

	}

	@GetMapping("/tecnico/editar/{id}")
	public String MostrarFormularioParaEditarTecnico(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("tecnico", servicio.obtenerTecnicoPorID(id));
		return "editar_tecnico";
	}

	@PostMapping("/tecnico/{id}")
	public String actualizarTecnico(@PathVariable Long id, @ModelAttribute("tecnico") tecnico tecnico) {
		tecnico tecnicoExistente = servicio.obtenerTecnicoPorID(id);
		tecnicoExistente.setId(id);
		tecnicoExistente.setNombre(tecnico.getNombre());
		tecnicoExistente.setApellido(tecnico.getApellido());
		tecnicoExistente.setTelefono(tecnico.getTelefono());

		servicio.actualizarTecnico(tecnicoExistente);
		return "redirect:/tecnico";
	}

	@GetMapping("/tecnico/{id}")
	public String eliminarTecnico(@PathVariable Long id) {
		servicio.eliminarTecnico(id);
		return "redirect:/tecnico";
	}

}
