package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Liquidacion;
import co.edu.ufps.cancha.util.Conexion;

public class LiquidacionDAO extends Conexion<Liquidacion> implements GenericDAO<Liquidacion>{

	public LiquidacionDAO(){
		super(Liquidacion.class);
	}
}
