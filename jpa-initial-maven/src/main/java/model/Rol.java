package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

public class Rol {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "activo")
    private boolean activo;
    
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    
    @ManyToMany(mappedBy = "roles")
    private List<Cliente> clientes;
    
    @Override
    public String toString() {
        return "Rol [id=" + id + ", activo=" + activo + ", descripcion=" + descripcion + "]";
    }

}
