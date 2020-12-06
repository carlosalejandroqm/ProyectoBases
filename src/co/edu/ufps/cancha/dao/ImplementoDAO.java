package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Implemento;
import co.edu.ufps.cancha.util.Conexion;

public class ImplementoDAO extends Conexion<Implemento> implements GenericDAO<Implemento>{

	public ImplementoDAO(){
		super(Implemento.class);
	}
}
