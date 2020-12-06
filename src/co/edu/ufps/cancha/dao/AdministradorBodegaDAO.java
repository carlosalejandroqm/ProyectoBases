package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.AdministradorBodega;
import co.edu.ufps.cancha.util.Conexion;

public class AdministradorBodegaDAO extends Conexion<AdministradorBodega> implements GenericDAO<AdministradorBodega>{

	public AdministradorBodegaDAO(){
		super(AdministradorBodega.class);
	}
}
