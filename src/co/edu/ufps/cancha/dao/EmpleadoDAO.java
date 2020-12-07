package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Empleado;
import co.edu.ufps.cancha.util.Conexion;

public class EmpleadoDAO extends Conexion<Empleado> implements GenericDAO<Empleado>{

	public EmpleadoDAO(){
		super(Empleado.class);
	}
	
	public Empleado encontrarEmpleado(Empleado em) {
		for(Empleado e: this.list()) {
			if(e.getUsuario().getNombre().equals(em.getUsuario().getNombre())) {
				return e;
			}
		}
		return null;
	}
}
