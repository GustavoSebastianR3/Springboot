package net.itinajero.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@GetMapping("/create")
	public String crear() {
		return "categorias/formCategorias";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		return "categorias/listCategorias";
	}
	
	@PostMapping("/save")
	public String guardar(@RequestParam("nom") String nombre, @RequestParam("des") String descripcion) {
		System.out.println("El nombre es " + nombre);
		System.out.println("La descripcion es: " + descripcion	);
		return "categorias/listCategorias";
	}

}
