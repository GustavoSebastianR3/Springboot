package net.itinajero.empleos.service;

import java.util.List;

import net.itinajero.empleos.model.Vacante;

public interface IVacantesService {
	List<Vacante> buscarTodas();
	Vacante buscarPorId(Integer idVacante);
	
	

}
