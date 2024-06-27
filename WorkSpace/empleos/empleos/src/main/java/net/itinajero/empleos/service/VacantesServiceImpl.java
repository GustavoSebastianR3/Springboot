package net.itinajero.empleos.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.empleos.model.Vacante;



@Service
public class VacantesServiceImpl implements IVacantesService {

	private List<Vacante> lista = null;
	public VacantesServiceImpl() {
		
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<>();
		
		try {
			//Creamos la oferta de trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ing. civil");
			vacante1.setDescripcion("Solicitamos ing civil para gestionar un puente peatoinal");
			vacante1.setFecha(fecha.parse("08-02-2019"));
			vacante1.setSalario(8500.0);
			vacante1.setDestacado(1); 
			vacante1.setImagen("logo1.png");
			
			//Creamos la oferta de trabajo 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Contador publico");
			vacante2.setDescripcion("Contador con experiencia minima  de 5 años titulado");
			vacante2.setFecha(fecha.parse("09-02-2019"));
			vacante2.setSalario(9200.0);
			vacante2.setDestacado(0); 
			vacante2.setImagen("logo2.png");


			

			
			
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
			vacante4.setImagen("logo4.png");


			
			
			// Agregamos los 4 objetos de tipo Vacante a la lista
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch(ParseException e){
			System.out.println("Error: " + e.getMessage());
		}
		
			
		
	}
	
	
	@Override
	public List<Vacante> buscarTodas() {
		return lista;
	}


	@Override
	public Vacante buscarPorId(Integer idVacante) {
		
		for(Vacante vac : lista ) {
			if(vac.getId()==idVacante)
				return vac;
		}
		return null;
	}


	@Override
	public void guardar(Vacante vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
