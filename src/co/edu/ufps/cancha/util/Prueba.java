package co.edu.ufps.cancha.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.edu.ufps.cancha.dao.CargoDAO;
import co.edu.ufps.cancha.dao.ClienteDAO;
import co.edu.ufps.cancha.dao.UsuarioDAO;
import co.edu.ufps.cancha.entities.Cargo;
import co.edu.ufps.cancha.entities.Cliente;
import co.edu.ufps.cancha.entities.Usuario;

public class Prueba {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ORM");
		EntityManager em = emf.createEntityManager();
		
		ClienteDAO c = new ClienteDAO();
		UsuarioDAO u = new UsuarioDAO();
		CargoDAO ca =new CargoDAO();
		
		Cargo cgo = new Cargo(1,"Administrador");
		Cargo cgo1 = new Cargo(2,"Cajero");
		Cargo cgo2 = new Cargo(3,"Administrador de Bodega");
		Cargo cgo3 = new Cargo(4,"Cliente");
		
		ca.insert(cgo);
		ca.insert(cgo1);
		ca.insert(cgo2);
		ca.insert(cgo3);
		
		Usuario us = new Usuario(1,"Sebasan07","1234",cgo3);
		
		u.insert(us);
		
		Cliente cl = new Cliente(1,"Juan","Sanchez","juans@gmail.com",0,"3219810616",us);
		
		c.insert(cl);
		
		System.out.println(c.list());
		
		em.close();
	}

}
