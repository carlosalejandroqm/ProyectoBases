package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import java.util.List;


/**
 * The persistent class for the bodega database table.
 * 
 */
@AllArgsConstructor
@Entity
@NamedQuery(name="Bodega.findAll", query="SELECT b FROM Bodega b")
public class Bodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_inventario")
	private Integer idInventario;

	//bi-directional many-to-one association to AdministradorBodega
	@ManyToOne
	@JoinColumn(name="administrador_bodega_clave_bodega")
	private AdministradorBodega administradorBodega;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="bodega")
	private List<Producto> productos;

	public Bodega() {
	}

	public Bodega(Integer idInventario, AdministradorBodega administradorBodega) {
		super();
		this.idInventario = idInventario;
		this.administradorBodega = administradorBodega;
	}
	
	public Integer getIdInventario() {
		return this.idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public AdministradorBodega getAdministradorBodega() {
		return this.administradorBodega;
	}

	public void setAdministradorBodega(AdministradorBodega administradorBodega) {
		this.administradorBodega = administradorBodega;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setBodega(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setBodega(null);

		return producto;
	}


}