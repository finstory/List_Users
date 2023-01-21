package spring.app.web.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import spring.app.web.entity.Usuario;


public interface UsuarioDao extends JpaRepository<Usuario, Integer> {
	 Usuario findByUsername(String username);
	
}
