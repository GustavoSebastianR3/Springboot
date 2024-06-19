package net.itinajero.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.itinajero.empleos.model.Vacante;

@Controller
public class HomeController {
	
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante>  lista = getVacantes();
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
	
	private List<Vacante> getVacantes(){
		
		
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<>();
		
		try {
			//Creamos la oferta de trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ing. civil");
			vacante1.setDescripcion("Solicitamos ing civil para gestionar un puente peatoinal");
			vacante1.setFecha(fecha.parse("08-02-2019"));
			vacante1.setSalario(8500.0);
			vacante1.setDestacado(1); 
			vacante1.setImagen("empresa1.png");
			
			//Creamos la oferta de trabajo 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Contador con experiencia minima  de 5 años titulado");
			vacante2.setFecha(fecha.parse("09-02-2019"));
			vacante2.setSalario(9200.0);
			vacante2.setDestacado(0); 
			vacante2.setImagen("empresa2.png");


			

			
			
			//Creamos la oferta de trabajo 3
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ing. Electrico");
			vacante3.setDescripcion("Empresa internacional exige un ing electrico por necesidades de mercado");
			vacante3.setFecha(fecha.parse("10-02-2019"));
			vacante3.setSalario(99500.0);
			vacante3.setDestacado(0); 

			
			
			//Creamos la oferta de trabajo 1
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador grafico");
			vacante4.setDescripcion("Creativo deiseñador para paneles pulicitarios de mercadeo");
			vacante4.setFecha(fecha.parse("11-02-2019"));
			vacante4.setSalario(9999.9);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa4.png");


			
			
			// Agregamos los 4 objetos de tipo Vacante a la lista
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch(ParseException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		return lista;
		
		
	}
	
	

}
