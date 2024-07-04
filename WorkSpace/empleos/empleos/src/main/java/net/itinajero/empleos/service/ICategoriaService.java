package net.itinajero.empleos.service;

import java.util.List;

import net.itinajero.empleos.model.Categoria;

import net.itinajero.empleos.model.Vacante;

public interface ICategoriaService {
	
	List<Categoria> buscarTodas();
	Categoria buscarPorId(Integer idCategoria);
	void guardar(Categoria categorias);

}
