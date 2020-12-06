package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Bodega;
import co.edu.ufps.cancha.util.Conexion;

public class BodegaDAO extends Conexion<Bodega> implements GenericDAO<Bodega>{

	public BodegaDAO(){
		super(Bodega.class);
	}
}
