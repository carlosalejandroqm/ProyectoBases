package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funciones database table.
 * 
 */
@Entity
@Table(name="funciones")
@NamedQuery(name="Funcione.findAll", query="SELECT f FROM Funcione f")
public class Funcione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_funciones")
	private int idFunciones;

	private String concepto;

	private String estado;

	//bi-directional many-to-one association to Contrato
	@ManyToOne
	private Contrato contrato;

	public Funcione() {
	}

	public int getIdFunciones() {
		return this.idFunciones;
	}

	public void setIdFunciones(int idFunciones) {
		this.idFunciones = idFunciones;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}