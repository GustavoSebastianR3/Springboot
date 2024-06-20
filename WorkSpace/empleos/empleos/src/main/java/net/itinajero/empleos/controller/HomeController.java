package net.itinajero.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.itinajero.empleos.model.Vacante;
import net.itinajero.empleos.service.IVacantesService;


@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacante;
	
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante>  lista =serviceVacante.buscarTodas();
		model.addAttribute("vacantes", lista);
		
		return "tabla";
		
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a internet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);
		model.addAttribute("vacante", vacante);
		
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		List<String> lista = new LinkedList<String>();
		
		lista.add("Ing. de sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		return "listado";
	}
	
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		/*model.addAttribute("mensaje", "Bienvenidos a empleos");
		model.addAttribute("fecha", new Date());
		*/
		
		String name = "Auxiliar de Contabilidad";
		Date date = new Date();
		double salary = 900.0;
		boolean avaiable = true;
		
		model.addAttribute("nombre", name );
		model.addAttribute("fecha", date);
		model.addAttribute("salario", salary);
		model.addAttribute("vigencia", avaiable);
		
		return "Home";
	}
	
	
	
	/* Metodo que retorna una lista de objetos */
	

}
