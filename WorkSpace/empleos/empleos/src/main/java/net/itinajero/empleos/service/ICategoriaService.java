package net.itinajero.empleos.service;

import java.util.List;

import net.itinajero.empleos.model.Categorias;
import net.itinajero.empleos.model.Vacante;

public interface ICategoriaService {
	
	List<Categorias> buscarTodas();
	Categorias buscarPorId(Integer idVacante);
	void guardar(Categorias categorias);

}
