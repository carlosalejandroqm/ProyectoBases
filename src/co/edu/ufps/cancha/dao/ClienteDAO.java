package co.edu.ufps.cancha.dao;

import java.util.List;

import co.edu.ufps.cancha.entities.Cliente;
import co.edu.ufps.cancha.util.Conexion;

public class ClienteDAO extends Conexion<Cliente> implements GenericDAO<Cliente> {

	public ClienteDAO() {
		super(Cliente.class);
	}

	public boolean existeCliente(Cliente cliente) {

		List<Cliente> list = this.list();
		if (list != null) {
			for (Cliente c : this.list()) {
				if (cliente.getUsuario().equals(c.getUsuario())) {
					return true;
				}
			}
		}
		return false;
	}
}
