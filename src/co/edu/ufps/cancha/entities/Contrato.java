package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the contrato database table.
 * 
 */
@AllArgsConstructor
@Entity
@NamedQuery(name="Contrato.findAll", query="SELECT c FROM Contrato c")
public class Contrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_contrato")
	private Integer idContrato;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	private Empleado empleado;

	//bi-directional many-to-one association to Funcione
	@OneToMany(mappedBy="contrato")
	private List<Funcione> funciones;

	//bi-directional many-to-one association to Liquidacion
	@OneToMany(mappedBy="contrato")
	private List<Liquidacion> liquidacions;

	public Contrato() {
	}
	
	public Contrato(Integer idContrato, Date fechaFin, Date fechaInicio, Empleado empleado) {
		super();
		this.idContrato = idContrato;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.empleado = empleado;
	}

	public Integer getIdContrato() {
		return this.idContrato;
	}

	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Funcione> getFunciones() {
		return this.funciones;
	}

	public void setFunciones(List<Funcione> funciones) {
		this.funciones = funciones;
	}

	public Funcione addFuncione(Funcione funcione) {
		getFunciones().add(funcione);
		funcione.setContrato(this);

		return funcione;
	}

	public Funcione removeFuncione(Funcione funcione) {
		getFunciones().remove(funcione);
		funcione.setContrato(null);

		return funcione;
	}

	public List<Liquidacion> getLiquidacions() {
		return this.liquidacions;
	}

	public void setLiquidacions(List<Liquidacion> liquidacions) {
		this.liquidacions = liquidacions;
	}

	public Liquidacion addLiquidacion(Liquidacion liquidacion) {
		getLiquidacions().add(liquidacion);
		liquidacion.setContrato(this);

		return liquidacion;
	}

	public Liquidacion removeLiquidacion(Liquidacion liquidacion) {
		getLiquidacions().remove(liquidacion);
		liquidacion.setContrato(null);

		return liquidacion;
	}

	

}