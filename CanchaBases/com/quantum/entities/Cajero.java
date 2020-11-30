package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cajero database table.
 * 
 */
@Entity
@NamedQuery(name="Cajero.findAll", query="SELECT c FROM Cajero c")
public class Cajero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_empleado")
	private int idEmpleado;

	@Column(name="clave_cajero")
	private String claveCajero;

	//bi-directional one-to-one association to Empleado
	@OneToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="cajero")
	private List<Factura> facturas;

	public Cajero() {
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getClaveCajero() {
		return this.claveCajero;
	}

	public void setClaveCajero(String claveCajero) {
		this.claveCajero = claveCajero;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setCajero(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setCajero(null);

		return factura;
	}

}