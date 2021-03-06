  
package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.List;


/**
 * The persistent class for the administrador_bodega database table.
 * 
 */
@AllArgsConstructor
@Entity
@Table(name="administrador_bodega")
@NamedQuery(name="AdministradorBodega.findAll", query="SELECT a FROM AdministradorBodega a")
public class AdministradorBodega implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empleado")
	private Integer idEmpleado;

	@Column(name="clave_bodega")
	private String claveBodega;

	//bi-directional one-to-one association to Empleado
	@OneToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Bodega
	@OneToMany(mappedBy="administradorBodega")
	private List<Bodega> bodegas;

	public AdministradorBodega() {
	}
	
	public AdministradorBodega(Integer idEmpleado, String claveBodega, Empleado empleado) {
		super();
		this.idEmpleado = idEmpleado;
		this.claveBodega = claveBodega;
		this.empleado = empleado;
	}

	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getClaveBodega() {
		return this.claveBodega;
	}

	public void setClaveBodega(String claveBodega) {
		this.claveBodega = claveBodega;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Bodega> getBodegas() {
		return this.bodegas;
	}

	public void setBodegas(List<Bodega> bodegas) {
		this.bodegas = bodegas;
	}

	public Bodega addBodega(Bodega bodega) {
		getBodegas().add(bodega);
		bodega.setAdministradorBodega(this);

		return bodega;
	}

	public Bodega removeBodega(Bodega bodega) {
		getBodegas().remove(bodega);
		bodega.setAdministradorBodega(null);

		return bodega;
	}



}