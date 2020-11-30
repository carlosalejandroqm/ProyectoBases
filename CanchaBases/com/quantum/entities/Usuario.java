package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="administrador_clave_administrador")
	private String administradorClaveAdministrador;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="cliente_id_cliente")
	private int clienteIdCliente;

	private String nombre;

	@Column(name="tipo_cargo")
	private String tipoCargo;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="usuario")
	private List<Reserva> reservas;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getAdministradorClaveAdministrador() {
		return this.administradorClaveAdministrador;
	}

	public void setAdministradorClaveAdministrador(String administradorClaveAdministrador) {
		this.administradorClaveAdministrador = administradorClaveAdministrador;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public int getClienteIdCliente() {
		return this.clienteIdCliente;
	}

	public void setClienteIdCliente(int clienteIdCliente) {
		this.clienteIdCliente = clienteIdCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoCargo() {
		return this.tipoCargo;
	}

	public void setTipoCargo(String tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setUsuario(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setUsuario(null);

		return reserva;
	}

}