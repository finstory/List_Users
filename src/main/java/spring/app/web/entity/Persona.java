package spring.app.web.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Entity
@Table(name = "persona")
@Component
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    @NotEmpty
    private String nombre;
    @NotEmpty
    private String apellido;
    private String email;
    private String telefono;
}
