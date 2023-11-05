package model;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cliente")
@Entity(name = "Cliente")
@Getter
@Setter
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "apellidoMaterno", length = 100, nullable = false)
	private String apellidoMaterno;

	@Column(name = "apellidoPaterno", length = 100, nullable = false)
	private String apellidoPaterno;

	@Column(name = "nombres", length = 50, nullable = false)
	private String nombres;

	@OneToMany(mappedBy = "cliente")
    private List<Cuenta> cuentas;

    @ManyToMany(mappedBy = "rol")
    private List<Rol> roles;
    
    @Override
    public String toString() {
        return "Cliente [id=" + id + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
                + ", nombres=" + nombres +"]";
    }

}
