package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Cargo;
import co.edu.ufps.cancha.util.Conexion;

public class CargoDAO extends Conexion<Cargo> implements GenericDAO<Cargo>{

	public CargoDAO(){
		super(Cargo.class);
	}
}
