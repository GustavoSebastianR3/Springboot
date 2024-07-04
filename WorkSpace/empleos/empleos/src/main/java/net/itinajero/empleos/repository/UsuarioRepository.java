package net.itinajero.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.empleos.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
