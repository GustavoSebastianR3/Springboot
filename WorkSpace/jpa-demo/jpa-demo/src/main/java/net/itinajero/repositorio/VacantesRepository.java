package net.itinajero.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	

}
