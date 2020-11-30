package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the implemento database table.
 * 
 */
@Entity
@NamedQuery(name="Implemento.findAll", query="SELECT i FROM Implemento i")
public class Implemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id__producto")
	private int idProducto;

	private String estado;

	//bi-directional one-to-one association to Producto
	@OneToOne
	@JoinColumn(name="id__producto")
	private Producto producto;

	public Implemento() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}