package net.itinajero.empleos.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import net.itinajero.empleos.model.Vacante;
import net.itinajero.empleos.repository.VacantesRepository;
import net.itinajero.empleos.service.IVacantesService;

@Service
@Primary
public class VacantesServiceJPA implements IVacantesService {
	
	@Autowired
	private VacantesRepository vacanRepo;
	

	@Override
	public List<Vacante> buscarTodas() {
		return vacanRepo.findAll();
		
	}

	@Override
	public Vacante buscarPorId(Integer idVacante) {
		Optional<Vacante> optional = vacanRepo.findById(idVacante);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Vacante vacante) {
		vacanRepo.save(vacante);
		
	}

}
