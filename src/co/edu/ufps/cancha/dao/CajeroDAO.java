package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Cajero;
import co.edu.ufps.cancha.util.Conexion;

public class CajeroDAO extends Conexion<Cajero> implements GenericDAO<Cajero>{

	public CajeroDAO(){
		super(Cajero.class);
	}
}
