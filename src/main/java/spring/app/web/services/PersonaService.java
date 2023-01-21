package spring.app.web.services;


import java.util.List;

import spring.app.web.entity.Persona;

public interface PersonaService {

	
	
	public void guardar(Persona persona);
	
	public void eliminar(Persona persona);
	
	public Persona encontrarPersona(Persona persona);

	List<Persona> listarPersonas();


	
	
}