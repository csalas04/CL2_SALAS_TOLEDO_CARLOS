package model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Movimiento")
@Entity(name = "Movimiento")
@Getter
@Setter
public class Movimiento {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 @Column(name = "descripcion")
    private String descripcion;
	 @Column(name = "fecha")
    private Date fecha;
    @Column(name = "monto", precision = 10, scale = 2)
    private double monto;
    
    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;
    
    @Override
    public String toString() {
        return "Movimiento [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", monto=" + monto
                + ", cuenta=" + cuenta + "]";
    }

}
