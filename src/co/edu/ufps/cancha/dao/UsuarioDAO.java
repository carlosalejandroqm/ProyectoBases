package co.edu.ufps.cancha.dao;

import co.edu.ufps.cancha.entities.Usuario;
import co.edu.ufps.cancha.util.Conexion;

public class UsuarioDAO extends Conexion<Usuario> implements GenericDAO<Usuario>{

	public UsuarioDAO(){
		super(Usuario.class);
	}
}
