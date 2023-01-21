package spring.app.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import spring.app.web.entity.Persona;


public interface PersonaDao extends CrudRepository<Persona, Long> {

	//ingresamos nuestro valor a modificar ':id' en parametro, indicandole
	//la clausra @Param con el mismo que ponemos en el Query.
	@Query(value = "select p from Persona p where p.idPersona = :id")
	 public List<Persona> busquedaPorID(@Param("id") Long id);
	
	@Query(value = "select p from Persona p where p.nombre LIKE :nombre")
	 public List<Persona> busquedaPorNombre(@Param("nombre") String nombre);
	
	@Query(value = "select p from Persona p where p.email LIKE :email ORDER BY p.nombre")
	 public List<Persona> emailDeHotmail(@Param("email") String email);
	
}
