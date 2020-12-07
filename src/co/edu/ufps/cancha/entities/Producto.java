package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@AllArgsConstructor
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id__producto")
	private Integer idProducto;

	private String nombre;
	
	private String descripcion;
	
	private Integer cantidad;

	//bi-directional one-to-one association to Consumible
	@OneToOne(mappedBy="producto")
	private Consumible consumible;

	//bi-directional one-to-one association to Implemento
	@OneToOne(mappedBy="producto")
	private Implemento implemento;

	//bi-directional many-to-one association to Bodega
	@ManyToOne
	private Bodega bodega;

	//bi-directional many-to-many association to Proveedor
	@ManyToMany
	@JoinTable(
		name="producto_proveedor"
		, joinColumns={
			@JoinColumn(name="id_producto")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_proveedor")
			}
		)
	private List<Proveedor> proveedors;

	public Producto() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
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

	public List<Proveedor> getProveedors() {
		return this.proveedors;
	}

	public void setProveedors(List<Proveedor> proveedors) {
		this.proveedors = proveedors;
	}

}