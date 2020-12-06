package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Funcione;
import co.edu.ufps.cancha.util.Conexion;

public class FuncionesDAO extends Conexion<Funcione> implements GenericDAO<Funcione>{

	public FuncionesDAO(){
		super(Funcione.class);
	}
}
