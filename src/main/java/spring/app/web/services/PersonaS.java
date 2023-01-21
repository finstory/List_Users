package spring.app.web.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.app.web.dao.PersonaDao;
import spring.app.web.entity.Persona;



@Service
public class PersonaS implements PersonaService {

	@Autowired
	private PersonaDao personaDao;

	//Creamos el servicio para administrar el Query, que lo añadira a nuestra
	//lista para manejarlo en el controlador.
	
	public List<Persona> busquedaPorID() {
		return personaDao.busquedaPorID((long) 15);
	}

	
	public List<Persona> busquedaPorNombre() {
		return personaDao.busquedaPorNombre("%" + "facu" + "%");
	}
	
	public List<Persona> soloHotmail() {
		return personaDao.emailDeHotmail("%" + "hotmail" + "%");
	}
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarPersonas() {
		return (List<Persona>) personaDao.findAll();
	}

	@Transactional
	@Override
	public void guardar(Persona persona) {
		personaDao.save(persona);
	}

	@Transactional
	@Override
	public void eliminar(Persona persona) {
		personaDao.delete(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {
		// Si envio la id de mi persona con "findByid",
		// me devuelve un opcional, q debo configurar en caso de null.
		return personaDao.findById(persona.getIdPersona()).orElse(persona);
	}

}
