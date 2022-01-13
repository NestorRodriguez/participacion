package co.com.acueducto.participacion.entities;

import java.io.Serializable;

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
		@NamedQuery(name = "GrupoInteres.FindAll", query = "SELECT gi FROM GrupoInteres gi ORDER BY gi.nombre") })
@Table(name = "grupo_interes")
public class GrupoInteres implements Serializable {
	// --------------------------------
	// Constantes de la Clase.
	// --------------------------------

	/**
	 * Constante de Serialización.
	 */
	private static final long serialVersionUID = -6362794385792247263L;

	// --------------------------------
	// Atributos de la Clase.
	// --------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_grupo_interes", nullable = false)
	private long idGrupoInteres;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	// --------------------------------
	// Constructor
	// --------------------------------
	
	public GrupoInteres() {
	}

	public GrupoInteres(long idGrupoInteres, String nombre, String estado, String descripcion) {
		this.idGrupoInteres = idGrupoInteres;
		this.nombre = nombre;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public long getIdGrupoInteres() {
		return idGrupoInteres;
	}

	public void setIdGrupoInteres(long idGrupoInteres) {
		this.idGrupoInteres = idGrupoInteres;
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
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "GrupoInteres [idGrupoInteres=" + idGrupoInteres + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
