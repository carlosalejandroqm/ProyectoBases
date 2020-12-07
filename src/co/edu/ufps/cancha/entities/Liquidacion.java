package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;


/**
 * The persistent class for the liquidacion database table.
 * 
 */
@AllArgsConstructor
@Entity
@NamedQuery(name="Liquidacion.findAll", query="SELECT l FROM Liquidacion l")
public class Liquidacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_liquidacion")
	private Integer idLiquidacion;

	private Integer basico;

	private Integer bonificaciones;

	@Column(name="horas_extra")
	private Integer horasExtra;

	//bi-directional many-to-one association to Contrato
	@ManyToOne
	private Contrato contrato;

	public Liquidacion() {
	}

	public Integer getIdLiquidacion() {
		return this.idLiquidacion;
	}

	public void setIdLiquidacion(Integer idLiquidacion) {
		this.idLiquidacion = idLiquidacion;
	}

	public Integer getBasico() {
		return this.basico;
	}

	public void setBasico(Integer basico) {
		this.basico = basico;
	}

	public Integer getBonificaciones() {
		return this.bonificaciones;
	}

	public void setBonificaciones(Integer bonificaciones) {
		this.bonificaciones = bonificaciones;
	}

	public Integer getHorasExtra() {
		return this.horasExtra;
	}

	public void setHorasExtra(Integer horasExtra) {
		this.horasExtra = horasExtra;
	}

	public Contrato getContrato() {
		return this.contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

}