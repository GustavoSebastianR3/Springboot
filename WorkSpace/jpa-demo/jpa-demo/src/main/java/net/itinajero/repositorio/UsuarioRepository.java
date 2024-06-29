package net.itinajero.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
