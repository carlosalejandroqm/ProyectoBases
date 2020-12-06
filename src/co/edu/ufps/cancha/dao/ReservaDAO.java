package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Reserva;
import co.edu.ufps.cancha.util.Conexion;

public class ReservaDAO extends Conexion<Reserva> implements GenericDAO<Reserva>{

	public ReservaDAO(){
		super(Reserva.class);
	}
}
