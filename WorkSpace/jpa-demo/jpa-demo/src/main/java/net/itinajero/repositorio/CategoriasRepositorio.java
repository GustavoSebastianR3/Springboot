package net.itinajero.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import net.itinajero.model.Categoria;

//public interface CategoriasRepositorio extends CrudRepository<Categoria, Integer> {

public interface CategoriasRepositorio extends JpaRepository<Categoria, Integer> {

}
