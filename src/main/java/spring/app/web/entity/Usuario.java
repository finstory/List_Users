package spring.app.web.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
@Component
public class Usuario implements Serializable{
    
	 private static final long serialVersionUID = 1L;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idUsuario;
	    
	    @NotEmpty
	    private String username;
	    
	    @NotEmpty
	    private String password;
	    
	    @OneToOne
	    @JoinColumn(name="id_rol")
	    private Rol rol;
}
