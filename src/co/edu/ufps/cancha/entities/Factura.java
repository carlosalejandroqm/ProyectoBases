package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;


/**
 * The persistent class for the factura database table.
 * 
 */
@AllArgsConstructor
@Entity
@Table(name="factura")
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="factura_id")
	private Integer facturaId;

	@Column(name="reserva_id_reserva")
	private Integer reservaIdReserva;

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

	public Integer getFacturaId() {
		return this.facturaId;
	}

	public void setFacturaId(Integer facturaId) {
		this.facturaId = facturaId;
	}

	public Integer getReservaIdReserva() {
		return this.reservaIdReserva;
	}

	public void setReservaIdReserva(Integer reservaIdReserva) {
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