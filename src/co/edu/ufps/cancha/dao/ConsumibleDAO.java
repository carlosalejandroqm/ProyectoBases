package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Consumible;
import co.edu.ufps.cancha.util.Conexion;

public class ConsumibleDAO extends Conexion<Consumible> implements GenericDAO<Consumible>{

	public ConsumibleDAO(){
		super(Consumible.class);
	}
}
