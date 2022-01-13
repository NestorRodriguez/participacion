package co.com.acueducto.participacion.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(value = {
		@NamedQuery(name = "GrupoPoblacional.FindAll", query = "SELECT gp FROM GrupoPoblacional gp ORDER BY gp.idGrupoPoblacional") })
@Table(name = "grupo_poblacional")
public class GrupoPoblacional {
	// --------------------------------
	// Constantes de la Clase.
	// --------------------------------

	

	// --------------------------------
	// Atributos de la Clase.
	// --------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_poblacional", nullable = false)
	private long idGrupoPoblacional;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private String estado;

	// --------------------------------
	// Constructor
	// --------------------------------

	public GrupoPoblacional(long idGrupoPoblacional, String nombre, String estado) {
		this.idGrupoPoblacional = idGrupoPoblacional;
		this.nombre = nombre;
		this.estado = estado;
	}

	public GrupoPoblacional() {
		super();
	}

	public long getIdGrupoPoblacional() {
		return idGrupoPoblacional;
	}

	public void setIdGrupoPoblacional(long idGrupoPoblacional) {
		this.idGrupoPoblacional = idGrupoPoblacional;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "GrupoPoblacional [idGrupoPoblacional=" + idGrupoPoblacional + ", nombre=" + nombre + ", estado="
				+ estado + "]";
	}
	
}
