package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;


/**
 * The persistent class for the reserva database table.
 * 
 */
@AllArgsConstructor
@Entity
@Table(name="reserva")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reserva")
	private Integer idReserva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_salida")
	private Date fechaSalida;

	@Column(name="id_factura")
	private Integer idFactura;

	@Column(name="tipo_cancha")
	private String tipoCancha;

	private String vigencia;

	//bi-directional one-to-one association to Factura
	@OneToOne(mappedBy="reserva")
	private Factura factura;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Reserva() {
	}

	public Integer getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Integer getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getTipoCancha() {
		return this.tipoCancha;
	}

	public void setTipoCancha(String tipoCancha) {
		this.tipoCancha = tipoCancha;
	}

	public String getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}