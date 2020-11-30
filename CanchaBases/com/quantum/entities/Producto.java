package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id__producto")
	private int idProducto;

	private int cantidad;

	private String descripcion;

	private String nombre;

	//bi-directional one-to-one association to Consumible
	@OneToOne(mappedBy="producto")
	private Consumible consumible;

	//bi-directional one-to-one association to Implemento
	@OneToOne(mappedBy="producto")
	private Implemento implemento;

	//bi-directional many-to-one association to Bodega
	@ManyToOne
	private Bodega bodega;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Consumible getConsumible() {
		return this.consumible;
	}

	public void setConsumible(Consumible consumible) {
		this.consumible = consumible;
	}

	public Implemento getImplemento() {
		return this.implemento;
	}

	public void setImplemento(Implemento implemento) {
		this.implemento = implemento;
	}

	public Bodega getBodega() {
		return this.bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

}