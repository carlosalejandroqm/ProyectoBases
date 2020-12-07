package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the cajero database table.
 * 
 */
@AllArgsConstructor
@Entity
@NamedQuery(name="Cajero.findAll", query="SELECT c FROM Cajero c")
public class Cajero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empleado")
	private Integer idEmpleado;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="cajero")
	private List<Factura> facturas;

	public Cajero() {
	}
	
	public Cajero(Integer idEmpleado) {
		this.idEmpleado=idEmpleado;
	}

	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setCajero(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setCajero(null);

		return factura;
	}
}