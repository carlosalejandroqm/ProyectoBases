package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Administrador;
import co.edu.ufps.cancha.util.Conexion;

public class AdministradorDAO extends Conexion<Administrador> implements GenericDAO<Administrador>{

	public AdministradorDAO(){
		super(Administrador.class);
	}
}
