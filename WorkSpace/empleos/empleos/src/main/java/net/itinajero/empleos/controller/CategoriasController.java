package net.itinajero.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriasController {
	
	@GetMapping("/create")
	public String crear(Model model) {
		return "categorias/formCategorias";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		return "categorias/listCategorias";
	}
	
	@GetMapping("/save")
	public String guardar(Model model) {
		return "categorias/listCategorias";
	}

}
