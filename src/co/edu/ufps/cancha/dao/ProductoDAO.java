package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Producto;
import co.edu.ufps.cancha.util.Conexion;

public class ProductoDAO extends Conexion<Producto> implements GenericDAO<Producto>{

	public ProductoDAO(){
		super(Producto.class);
	}
}
