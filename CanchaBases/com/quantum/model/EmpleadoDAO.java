package com.quantum.model;

import com.quantum.util.GenericDAO;
import com.quantum.util.Conexion;
import com.quantum.entities.Empleado;

public class EmpleadoDAO extends Conexion<Empleado> implements GenericDAO<Empleado> {

	public EmpleadoDAO() {
		super(Empleado.class);
	}

	public static void main(String[] args) {
		EmpleadoDAO t = new EmpleadoDAO();
		System.out.println(t.list());
	}
}
