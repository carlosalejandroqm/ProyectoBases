package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Cliente;
import co.edu.ufps.cancha.util.Conexion;

public class ClienteDAO extends Conexion<Cliente> implements GenericDAO<Cliente>{

	public ClienteDAO(){
		super(Cliente.class);
	}
}
