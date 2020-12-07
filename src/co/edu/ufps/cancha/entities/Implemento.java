package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;


/**
 * The persistent class for the implemento database table.
 * 
 */
@AllArgsConstructor
@Entity
@NamedQuery(name="Implemento.findAll", query="SELECT i FROM Implemento i")
public class Implemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id__producto")
	private Integer idProducto;

	private String estado;

	//bi-directional one-to-one association to Producto
	@OneToOne
	@JoinColumn(name="id__producto")
	private Producto producto;

	public Implemento() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
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