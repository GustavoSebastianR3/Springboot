package net.itinajero.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.itinajero.empleos.model.Categoria;



//public interface CategoriasRepositorio extends CrudRepository<Categoria, Integer> {

public interface CategoriasRepositorio extends JpaRepository<Categoria, Integer> {

}
