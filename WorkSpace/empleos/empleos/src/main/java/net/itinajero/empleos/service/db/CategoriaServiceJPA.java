package net.itinajero.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.itinajero.empleos.model.Categoria;
import net.itinajero.empleos.repository.CategoriasRepositorio;
import net.itinajero.empleos.service.ICategoriaService;

@Service
@Primary
public class CategoriaServiceJPA implements ICategoriaService {
	
	@Autowired
	private  CategoriasRepositorio CateRepo;

	@Override
	public List<Categoria> buscarTodas() {
	
		return CateRepo.findAll();
	}

	@Override
	public Categoria buscarPorId(Integer idVacante) {
		Optional<Categoria>  optinal =   CateRepo.findById(idVacante);
		
		if(optinal.isPresent()) {
		return optinal.get();
		}
		return null;
	}

	@Override
	public void guardar(Categoria categorias) {

		CateRepo.save(categorias);
		
	}

}
