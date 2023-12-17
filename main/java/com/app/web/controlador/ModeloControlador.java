package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Modelo;
import com.app.web.services.ModeloServicio;

@Controller
public class ModeloControlador {
	
	@Autowired
	private ModeloServicio servicio;
	
	@GetMapping("/modelos")
	public String listarModelos(Model modelo) {
		modelo.addAttribute("modelos", servicio.listarTodosLosModelos());
		return "modelos"; //nos retorna al archivo modelos
	}
	
	@GetMapping("/modelos/nuevo")
	public String crearModeloFormula(Model modelo) {
		Modelo modelo1 = new Modelo();
		modelo.addAttribute("modelo", modelo1);
		return "crear_modelo";
	}
	
	
	@PostMapping("/modelos")
	public String guardarModelo(@ModelAttribute("modelo") Modelo modelo) {
		servicio.guardarModelo(modelo);
		return "redirect:/modelos";
	}

	@GetMapping("/modelos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("modelo", servicio.obtenerModeloPorId(id));
		return "editar_modelo";
		
	}
	
	@PostMapping("/modelos/{id}")
	public String actualizarModelo(@PathVariable Long id, @ModelAttribute("modelo") Modelo modelo) {
		Modelo modeloExistente = servicio.obtenerModeloPorId(id);
		modeloExistente.setId(id);
		modeloExistente.setNombre(modelo.getNombre());
		modeloExistente.setDescripcion(modelo.getDescripcion());
		
		servicio.actulizarModelo(modeloExistente);
		return "redirect:/modelos";
			
	}
	
	@GetMapping("/modelos/{id}")
	public String eliminarModelo(@PathVariable Long id) {
		servicio.eliminarModelo(id);
		return "redirect:/modelos";
		
	}
}
