package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_empleado")
	private int idEmpleado;

	private String apellido;

	private String correo;

	private String dni;

	@Column(name="horas_extra")
	private int horasExtra;

	private String nombre;

	private int telefono;

	//bi-directional one-to-one association to Administrador
	@OneToOne(mappedBy="empleado")
	private Administrador administrador;

	//bi-directional one-to-one association to AdministradorBodega
	@OneToOne(mappedBy="empleado")
	private AdministradorBodega administradorBodega;

	//bi-directional many-to-one association to Contrato
	@OneToMany(mappedBy="empleado")
	private List<Contrato> contratos;

	//bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name="cargo")
	private Cargo cargoBean;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Empleado() {
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
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

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getHorasExtra() {
		return this.horasExtra;
	}

	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Administrador getAdministrador() {
		return this.administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public AdministradorBodega getAdministradorBodega() {
		return this.administradorBodega;
	}

	public void setAdministradorBodega(AdministradorBodega administradorBodega) {
		this.administradorBodega = administradorBodega;
	}

	public List<Contrato> getContratos() {
		return this.contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	public Contrato addContrato(Contrato contrato) {
		getContratos().add(contrato);
		contrato.setEmpleado(this);

		return contrato;
	}

	public Contrato removeContrato(Contrato contrato) {
		getContratos().remove(contrato);
		contrato.setEmpleado(null);

		return contrato;
	}

	public Cargo getCargoBean() {
		return this.cargoBean;
	}

	public void setCargoBean(Cargo cargoBean) {
		this.cargoBean = cargoBean;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}