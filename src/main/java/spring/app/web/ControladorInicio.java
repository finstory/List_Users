package spring.app.web;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring.app.web.entity.Persona;
import spring.app.web.entity.Usuario;
import spring.app.web.services.PersonaS;
import spring.app.web.services.UsuarioS;

@Controller
public class ControladorInicio {

	@Autowired
	private PersonaS personaS;

	@Autowired
	private UsuarioS usuarioS;

	@GetMapping("/login")
	public String login() {
		return "web/login";
	}

//	@GetMapping("/")
//	public String inicio(Model model) {
//		var personas = personaS.listarPersonas();
//		model.addAttribute("personas", personas);
//	
//		return "web/index";
//	}

	@GetMapping("/")
	public String inicio(Model model) {
		var personas = personaS.listarPersonas();
		model.addAttribute("personas", personas);

		Usuario usuario = usuarioS.encontrarUser();
		String rol = usuario.getRol().getNombre();
		model.addAttribute("usuario", usuario);
		model.addAttribute("rol", rol);
		return "web/index";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "web/modificar";
	}

//	La anotación @Valid asoscia las etiquetas de los atributos de nuestro
//	objeto. Luego Errors recibe los datos del error que sucedió, en caso 
//	de existir 1, con el if se evita sublimar atributos con errores.
	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errores) {
		if (errores.hasErrors()) {
			return "web/modificar";
		}
		personaS.guardar(persona);
		return "redirect:/";
	}

//	Nos trameos el id colocado en nuestra dirección, que lo insertamos e@n 
//	el formulario. Spring automaticamente rellenará el atributo id de nuestro
//	objeto persona.
//	Luego lo buscamos en mysql para rellenar los demás atributos, esto nos
// servira para autorellenar los campos en nuestra pag. de modificación.
	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) {

		// Rellena atributos por id.
		persona = personaS.encontrarPersona(persona);

		// Envia esa persona.
		model.addAttribute("persona", persona);
		return "web/modificar";
	}

	@GetMapping("/eliminar/{idPersona}")
	public String eliminar(Persona persona, Model model) {

		// Elimina la persona por id.
		personaS.eliminar(persona);

		// Redirecciona al index, sino redireccionamos, tendríamos
		// un index desactualizado.
		return "redirect:/";
	}


}
