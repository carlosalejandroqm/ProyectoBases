package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Compra;
import co.edu.ufps.cancha.util.Conexion;

public class CompraDAO extends Conexion<Compra> implements GenericDAO<Compra>{

	public CompraDAO(){
		super(Compra.class);
	}
}
