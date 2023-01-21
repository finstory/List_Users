package spring.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.app.web.entity.Persona;
import spring.app.web.entity.Usuario;
import spring.app.web.services.PersonaS;
import spring.app.web.services.UsuarioS;

@RestController
public class QueryC {
		
	@Autowired
	PersonaS personaS;
	

	@RequestMapping(value = "persona/{idPersona}")
	public Persona getUsuario(Persona persona) {
		return personaS.encontrarPersona(persona);
	}
	
}
