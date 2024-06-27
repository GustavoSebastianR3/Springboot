package net.itinajero.empleos.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.empleos.model.Vacante;
import net.itinajero.empleos.service.ICategoriaService;
import net.itinajero.empleos.service.IVacantesService;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IVacantesService serviceVacante;
	
	@Autowired
	private ICategoriaService serviceCategoriaService;
	
	@GetMapping("/create")
	public String crear(Vacante vacante, Model model) {
		model.addAttribute("categorias", serviceCategoriaService.buscarTodas());
		return "vacantes/formVacante";
	}
	
	@PostMapping("/save")
	public String guardar(Vacante vacante, BindingResult result, RedirectAttributes atributes) {
		
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
		}
		
		serviceVacante.guardar(vacante);
		atributes.addFlashAttribute("msj", "Registro guardado");
		System.out.println("Vacante: " + vacante);
		
		return "redirect:/vacantes/index";
	}
	
	/* @PostMapping("/save")
	public String guardar(@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion,
			@RequestParam("estatus") String estatus, @RequestParam("fecha") String fecha, @RequestParam("destacado") int destacado
			, @RequestParam("salario") double salario, @RequestParam("detalles") String detalles) {
		
		System.out.println("El nombre es : " + nombre);
		System.out.println("La descripcion es : " + descripcion);
		System.out.println("La fecha : " + fecha);
		System.out.println("El estado es : " + estatus);
		System.out.println("Destacado : " + destacado);
		System.out.println("Su salario es : " + salario);
		System.out.println("Detalles : " + detalles);
		
		return "vacantes/listVacantes";
	}
	*/
	
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
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		
		//1. obtener todas las vacantes (recuperarlas con la clase servicio)
		List<Vacante> lista = serviceVacante.buscarTodas();
		
		//2. Agregar al modelo el listado de vacantes
		model.addAttribute("vacantes", lista);
		
		//3. renderizar las vacantes a la vista 
		
		//4.Agregar al menu una opcion llamada "Vacantes" configurado a la url "vacantes/index"
		return "vacantes/listVacantes";
	}
	
	
	
	
	
	
}
