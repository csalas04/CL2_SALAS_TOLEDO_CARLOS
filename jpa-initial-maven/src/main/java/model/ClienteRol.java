package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name ="Cliente_Rol")
@Entity (name ="Cliente_Rol")
@Setter
@Getter

public class ClienteRol {
    
	@Id
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
	@Id
    @ManyToOne
    @JoinColumn(name="roles_id")
    private Rol rol;
	
	@Override 
	public String toString() {
		return "Cliente_Rol {cliente = " +cliente+" ,rol = "+rol+"}"; 
	}
}
