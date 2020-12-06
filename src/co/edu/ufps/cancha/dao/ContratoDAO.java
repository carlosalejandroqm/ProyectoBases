package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Contrato;
import co.edu.ufps.cancha.util.Conexion;

public class ContratoDAO extends Conexion<Contrato> implements GenericDAO<Contrato>{

	public ContratoDAO(){
		super(Contrato.class);
	}
}
