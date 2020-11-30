package com.quantum.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the liquidacion database table.
 * 
 */
@Entity
@NamedQuery(name="Liquidacion.findAll", query="SELECT l FROM Liquidacion l")
public class Liquidacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_liquidacion")
	private int idLiquidacion;

	private int basico;

	private int bonificaciones;

	@Column(name="horas_extra")
	private int horasExtra;

	//bi-directional many-to-one association to Contrato
	@ManyToOne
	private Contrato contrato;

	public Liquidacion() {
	}

	public int getIdLiquidacion() {
		return this.idLiquidacion;
	}

	public void setIdLiquidacion(int idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}

	public int getBasico() {
		return this.basico;
	}

	public void setBasico(int basico) {
		this.basico = basico;
	}

	public int getBonificaciones() {
		return this.bonificaciones;
	}

	public void setBonificaciones(int bonificaciones) {
		this.bonificaciones = bonificaciones;
	}

	public int getHorasExtra() {
		return this.horasExtra;
	}

	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}