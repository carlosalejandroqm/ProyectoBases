package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private int idCliente;

	private String apellido;

	private String correo;

	@Column(name="id_usuario")
	private String idUsuario;

	private String nombre;

	@Column(name="nro_reservas")
	private int nroReservas;

	private String telefono;

	@Column(name="usuario_id_usuario")
	private int usuarioIdUsuario;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNroReservas() {
		return this.nroReservas;
	}

	public void setNroReservas(int nroReservas) {
		this.nroReservas = nroReservas;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getUsuarioIdUsuario() {
		return this.usuarioIdUsuario;
	}

	public void setUsuarioIdUsuario(int usuarioIdUsuario) {
		this.usuarioIdUsuario = usuarioIdUsuario;
	}

}