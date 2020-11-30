package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Funcioness database table.
 * 
 */
@Entity
@Table(name="Funciones")
@NamedQuery(name="Funciones.findAll", query="SELECT f FROM Funciones f")
public class Funciones implements Serializable {
	private static final long serialVersionUID = 1L;

	private String concepto;

	private String estado;

	@Column(name="id_Funcioness")
	private int idFuncioness;

	//bi-directional many-to-one association to Contrato
	@ManyToOne
	private Contrato contrato;

	public Funciones() {
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

	public int getIdFuncioness() {
		return this.idFuncioness;
	}

	public void setIdFuncioness(int idFuncioness) {
		this.idFuncioness = idFuncioness;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}