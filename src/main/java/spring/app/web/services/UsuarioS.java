package spring.app.web.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.app.web.dao.UsuarioDao;
import spring.app.web.entity.Usuario;
@Service("userDetailsService")
public class UsuarioS implements UserDetailsService {

	 
	@Autowired
    private UsuarioDao usuarioDao;
	
	@Autowired
	private Usuario usuario;
	
	 @Override
	    @Transactional(readOnly=true)
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Usuario usuario = usuarioDao.findByUsername(username);
	        
	        if(usuario == null){
	            throw new UsernameNotFoundException(username);
	        }
	        
	        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
	        SimpleGrantedAuthority rol = new SimpleGrantedAuthority(usuario.getRol().getNombre());
	        roles.add(rol);
	        return new User(usuario.getUsername(), usuario.getPassword(), roles);
	    }
	
	
	
	
	
	
	//Es testeo lo q sige.
	
	public Usuario encontrarUser() {
		return usuarioDao.findById(1).orElse(usuario);
		
	}

}
