package net.itinajero;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.expression.spel.ast.OpInc;

import net.itinajero.model.Categoria;
import net.itinajero.model.Perfil;
import net.itinajero.model.Usuario;
import net.itinajero.model.Vacante;
import net.itinajero.repositorio.CategoriasRepositorio;
import net.itinajero.repositorio.PerfilRepository;
import net.itinajero.repositorio.UsuarioRepository;
import net.itinajero.repositorio.VacantesRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private CategoriasRepositorio repoCategorias;
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Autowired
	private PerfilRepository repoPerfil;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		buscarUsuario();
	}
	
	private void buscarVacantes() {
		List<Vacante> lista = repoVacantes.findAll();
		for(Vacante vac : lista) {
			System.out.println(vac.getId() + " " + vac.getNombre() + " ---->  " + vac.getCategoria().getNombre());
		}
	}

	private void buscarTodosJpa() {
		List<Categoria> categorias  =  repoCategorias.findAll();
		for(Categoria cat : categorias) 
			System.out.println(cat);
		
	}
	
	private void guardarVacante() {
		Vacante vac = new Vacante();
		vac.setNombre("Matematico");
		vac.setDescripcion("Experto en numeros");
		vac.setSalario(5000.0);
		vac.setEstatus("Aprobada");
		vac.setDestacado(0);
		vac.setFecha(new Date());
		vac.setImagen("escuela.png");
		vac.setDetalles("<h1>Los requisitos para profesor de matematicas </h1>");
		Categoria cat = new Categoria();
		cat.setId(15);
		vac.setCategoria(cat);
		repoVacantes.save(vac);
		
		}
	
	private void guardar() {
		Categoria cat = new Categoria();
		cat.setNombre("finanzas");
		cat.setDescripcion("finaznsas y contabilidad");

		System.out.println(cat.toString());

		repoCategorias.save(cat);
		System.out.println(cat);

	}

	private void buscarPorId() {
		Optional<Categoria> optional = repoCategorias.findById(1);
		if (optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("Categoria no encontrada");

	}

	private void modificar() {
		Optional<Categoria> optional = repoCategorias.findById(2);
		if (optional.isPresent()) {

			Categoria catTemp = optional.get();
			catTemp.setNombre("Ingieneria de software");
			catTemp.setDescripcion("Desarrollo de sistemas");
			repoCategorias.save(catTemp);
			System.out.println(optional.get());
		} else {
			System.out.println("Categoria no encontrada");
		}

	}

	private void delete() {
		int idCategoria = 1;
		repoCategorias.deleteById(idCategoria);

	}

	private void conteo() {
		long count = repoCategorias.count();
		System.out.println("el conteo es: " + count);
	}

	public void buscarPoriD() {
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(1);
		ids.add(5);
		ids.add(11);

		for (Integer numero : ids)
			System.out.println(numero);

		Iterable<Categoria> categorias = repoCategorias.findAllById(ids);
		for (Categoria cat : categorias)
			System.out.println(cat);
	}
	
	private List<Perfil> getPefiles(){
		List<Perfil> lista = new LinkedList<Perfil>();
		Perfil perfil1 = new Perfil();
		perfil1.setPerfil("SUPERVISOR");
		
		Perfil per2 = new Perfil();
		per2.setPerfil("ADMINISTRADOR");
		
		
		Perfil per3 = new Perfil();
		per3.setPerfil("USUARIO");
		
		lista.add(per3);
		lista.add(per2);
		lista.add(perfil1);
		return lista;
	}
	
	private void crearPerfil() {
		repoPerfil.saveAll(getPefiles());
		
	}
	
	 private void crearUsuarioPerfil() {
		 Usuario user = new Usuario();
		 user.setNombre("Gustavo");
		 user.setEmail("gus@gmail.com");
		 user.setFechaRegistro(new Date());
		 user.setEstatus(1);
		 user.setPassword("1234");
		 user.setUsername("gus12");
		 
		 Perfil per1 = new Perfil();
		 per1.setId(2);
		 
		 Perfil per2 = new Perfil();
		 per2.setId(3);
		 
		 user.agregar(per1);
		 user.agregar(per2);
		 
		 repoUsuario.save(user);
		 

	 }
	 
	 private void buscarUsuario() {
		 Optional<Usuario> optional =  repoUsuario.findById(1);
		 if(optional.isPresent()) {
			 Usuario u = optional.get();
			 System.out.println("Usuario " + u.getNombre());
			 System.out.println("Perfiles asignados " );
			 for(Perfil p : u.getPerfiles()) {
				 System.out.println(p.getPerfil());
			 }
		 }else
			 System.out.println( "Usuario no encontrado");
		 }
	 }


