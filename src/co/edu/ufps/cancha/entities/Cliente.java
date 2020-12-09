package co.edu.ufps.cancha.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="cliente")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cliente")
	private Integer idCliente;

	private String apellido;

	private String correo;

	private String nombre;

	@Column(name="nro_reservas")
	private Integer nroReservas;

	private String telefono;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	private Usuario usuario;

	public Cliente(Integer idCliente, String nombre, String apellido, String correo, Integer nroReservas,
			String telefono, Usuario usuario) {
		super();
		this.idCliente = idCliente;
		this.apellido = apellido;
		this.correo = correo;
		this.nombre = nombre;
		this.nroReservas = nroReservas;
		this.telefono = telefono;
		this.usuario = usuario;
	}

	

}