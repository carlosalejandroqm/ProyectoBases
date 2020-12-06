package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the consumible database table.
 * 
 */
@Entity
@NamedQuery(name="Consumible.findAll", query="SELECT c FROM Consumible c")
public class Consumible implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id__producto")
	private int idProducto;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vencimiento")
	private Date fechaVencimiento;

	private int precio;

	//bi-directional one-to-one association to Producto
	@OneToOne
	@JoinColumn(name="id__producto")
	private Producto producto;

	public Consumible() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}