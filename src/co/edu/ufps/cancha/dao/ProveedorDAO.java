package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Proveedor;
import co.edu.ufps.cancha.util.Conexion;

public class ProveedorDAO extends Conexion<Proveedor> implements GenericDAO<Proveedor>{

	public ProveedorDAO(){
		super(Proveedor.class);
	}
}
