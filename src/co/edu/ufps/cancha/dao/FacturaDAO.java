package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Factura;
import co.edu.ufps.cancha.util.Conexion;

public class FacturaDAO extends Conexion<Factura> implements GenericDAO<Factura>{

	public FacturaDAO(){
		super(Factura.class);
	}
}
