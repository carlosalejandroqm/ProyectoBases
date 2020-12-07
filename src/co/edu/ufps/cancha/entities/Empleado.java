package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@AllArgsConstructor
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empleado")
	private Integer idEmpleado;

	private String apellido;

	private String correo;

	private String dni;

	@Column(name="horas_extra")
	private Integer horasExtra;

	private String nombre;

	private Integer telefono;

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

	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
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

	public Integer getHorasExtra() {
		return this.horasExtra;
	}

	public void setHorasExtra(Integer horasExtra) {
		this.horasExtra = horasExtra;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
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

	public Empleado(Integer idEmpleado, String dni, String nombre, String apellido, String correo,  Integer horasExtra, 
			Integer telefono, Administrador administrador, AdministradorBodega administradorBodega, Cargo cargoBean,
			Usuario usuario) {
		super();
		this.idEmpleado = idEmpleado;
		this.apellido = apellido;
		this.correo = correo;
		this.dni = dni;
		this.horasExtra = horasExtra;
		this.nombre = nombre;
		this.telefono = telefono;
		this.administrador = administrador;
		this.administradorBodega = administradorBodega;
		this.cargoBean = cargoBean;
		this.usuario = usuario;
	}

}