package co.com.acueducto.participacion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries(value = {
		@NamedQuery(name = "SubGrupoInteres.FindAll", query = "SELECT sgi FROM SubGrupoInteres sgi ORDER BY sgi.nombre"),
		@NamedQuery(name = "SubGrupoInteres.buscarSubGrupoInteresByIdGrupoInteres", query = "SELECT sgi FROM SubGrupoInteres sgi WHERE sgi.grupoInteres.idGrupoInteres = :idGrupoInteres"),
})

@Entity
@Table(name = "sub_grupo_interes")
public class SubGrupoInteres implements Serializable {
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
	@Column(name = "id_sub_grupo_interes", nullable = false)
	private long idSubGrupoInteres;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_grupo_interes", nullable = true, updatable = true)
	private GrupoInteres grupoInteres;

	// --------------------------------
	// Constructor
	// --------------------------------

	public SubGrupoInteres() {
	}

	public SubGrupoInteres(long idSubGrupoInteres, String nombre, String estado, GrupoInteres grupoInteres) {
		super();
		this.idSubGrupoInteres = idSubGrupoInteres;
		this.nombre = nombre;
		this.estado = estado;
		this.grupoInteres = grupoInteres;
	}

	//-------------------------
	//Métodos de la clase
	//-------------------------
	
	public long getIdSubGrupoInteres() {
		return idSubGrupoInteres;
	}

	public void setIdSubGrupoInteres(long idSubGrupoInteres) {
		this.idSubGrupoInteres = idSubGrupoInteres;
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

	public GrupoInteres getGrupoInteres() {
		return grupoInteres;
	}

	public void setGrupoInteres(GrupoInteres grupoInteres) {
		this.grupoInteres = grupoInteres;
	}

	@Override
	public String toString() {
		return "SubGrupoInteres [idSubGrupoInteres=" + idSubGrupoInteres + ", nombre=" + nombre + ", estado=" + estado
				+ ", grupoInteres=" + grupoInteres + "]";
	}

}
