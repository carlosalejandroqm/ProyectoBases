package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the administrador database table.
 * 
 */
@Entity
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_empleado")
	private int idEmpleado;

	@Column(name="clave_administrador")
	private String claveAdministrador;

	//bi-directional one-to-one association to Empleado
	@OneToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

	public Administrador() {
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getClaveAdministrador() {
		return this.claveAdministrador;
	}

	public void setClaveAdministrador(String claveAdministrador) {
		this.claveAdministrador = claveAdministrador;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}