package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the cargo database table.
 * 
 */
@AllArgsConstructor
@Entity
@Table(name="cargo")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cargo")
	private Integer idCargo;

	private String descripcion;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="cargoBean")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="cargo")
	private List<Usuario> usuarios;

	public Cargo() {
	}
	
	public Cargo(Integer idCargo, String descripcion) {
		super();
		this.idCargo = idCargo;
		this.descripcion = descripcion;
	}
	
	public Integer getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setCargoBean(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setCargoBean(null);

		return empleado;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setCargo(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setCargo(null);

		return usuario;
	}

}