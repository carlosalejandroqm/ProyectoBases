package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="factura_id")
	private int facturaId;

	@Column(name="reserva_id_reserva")
	private int reservaIdReserva;

	//bi-directional many-to-one association to Cajero
	@ManyToOne
	@JoinColumn(name="cajero_clave_cajero")
	private Cajero cajero;

	//bi-directional one-to-one association to Reserva
	@OneToOne
	@JoinColumn(name="factura_id")
	private Reserva reserva;

	public Factura() {
	}

	public int getFacturaId() {
		return this.facturaId;
	}

	public void setFacturaId(int facturaId) {
		this.facturaId = facturaId;
	}

	public int getReservaIdReserva() {
		return this.reservaIdReserva;
	}

	public void setReservaIdReserva(int reservaIdReserva) {
		this.reservaIdReserva = reservaIdReserva;
	}

	public Cajero getCajero() {
		return this.cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}