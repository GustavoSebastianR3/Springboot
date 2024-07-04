package net.itinajero.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.itinajero.empleos.model.Vacante;



public interface VacantesRepository extends JpaRepository<Vacante, Integer> {
	

}
