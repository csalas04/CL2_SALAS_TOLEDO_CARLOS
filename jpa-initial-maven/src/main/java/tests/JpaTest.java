package tests;

import java.util.Arrays;
import java.util.List;

import model.Cliente;
import model.Rol;
import model.ClienteRol;
import model.Cuenta;
import model.TipoCuenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaTest {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
		EntityManager manager = factory.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		tx.begin();
		
		Cliente cliente = new Cliente();
		cliente.setApellidoMaterno("Toledo");
		cliente.setApellidoPaterno("Salas");
		cliente.setNombres("Carlos Ricardo");
		
		Rol r1 = new Rol();
		r1.setDescripcion("Rol 1");
		
		Rol r2 = new Rol();
		r2.setDescripcion("Rol 2");
		
		List <Rol> roles = Arrays.asList(r1,r2);
		
		ClienteRol clienteRol = new ClienteRol();
        clienteRol.setCliente(cliente);
        clienteRol.setRol(r1);

        Cuenta cuenta = new Cuenta();
        cuenta.setActiva(true);
        cuenta.setNumeroCuenta("123456789");
        cuenta.setSaldo(1000.0);
        cuenta.setCliente(cliente);
        
        TipoCuenta tipoCuenta = new TipoCuenta();
        tipoCuenta.setDescripcion("Tipo de Cuenta");
        tipoCuenta.setMoneda("USD");
        
        cuenta.setTipoCuenta(tipoCuenta);
		
        manager.persist(cliente);
		tx.commit();

		List<Cliente> lista = manager.createQuery("from Cliente", Cliente.class).getResultList();
		for (Cliente em : lista) {
			System.out.println(em);
		}
		
		
	}

}
