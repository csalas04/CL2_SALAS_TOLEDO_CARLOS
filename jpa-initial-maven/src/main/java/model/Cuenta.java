package model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Cuenta")
@Entity(name = "Cuenta")
@Getter
@Setter
public class Cuenta {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "activa")
	    private boolean activa;
	    
		@Column(name = "numeroCuenta", length = 100, nullable = false)
	    private String numeroCuenta;
		
		@Column(name = "saldo", precision = 10, scale = 2)
	    private double saldo;
	    
	    @ManyToOne
	    @JoinColumn(name = "cliente_id")
	    private List<Cliente> cliente;
	    
	    @OneToOne
	    @JoinColumn(name = "tipoCuenta_id")
	    private TipoCuenta tipoCuenta;
	    
	    @OneToMany(mappedBy = "cuenta")
	    private List<Movimiento> movimientos;
	    
	    @Override
	    public String toString() {
	        return "Cuenta [id=" + id + ", activa=" + activa + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo
	                + "]";
	    }

}
