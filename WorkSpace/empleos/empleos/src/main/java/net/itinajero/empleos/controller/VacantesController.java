package net.itinajero.empleos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.empleos.model.Vacante;
import net.itinajero.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService serviceVacante;
	
	@GetMapping("/delete")
	public String eliminar( @RequestParam("id") int idVacante, Model model) {
		System.out.println("Borrado vacante con id: "+ idVacante);
		model.addAttribute("id", idVacante);
		return "mensaje";
		
	}
	//AUTOWIRED - 
	//CUALES SON LOS 4 PILARES DE LA PROGRAMACION ORIENTADA A OBJETO //ABSTRACCION //HERENCIA //  ENCAPSULAMIENTO // POLIMORFISMO
	//POSTMAPPING - METODO MÁS SEGURO 
	
	//RESTFULL - CONCEPTOS CLAROS
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idVacante, Model model) {
		
		Vacante vacante = serviceVacante.buscarPorId(idVacante);
		System.out.println("El id del vacante es " + vacante);
		model.addAttribute("vacante", vacante);
		return "detalle";
		
	}

}
