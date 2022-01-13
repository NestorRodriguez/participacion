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
		@NamedQuery(name = "SubDeSubDeSubGrupoInteres.FindAll", query = "SELECT sgi FROM SubDeSubDeSubGrupoInteres sgi ORDER BY sgi.nombre"),
		@NamedQuery(name = "SubDeSubDeSubGrupoInteres.buscarSubDeSubDeSubGrupoInteresByIdSubGrupoInteres", query = "SELECT sgi FROM SubDeSubDeSubGrupoInteres sgi WHERE sgi.subDeSubGrupoInteres.idSubSubGrupoInteres = :idSubSubGrupoInteres"),
})

@Entity
@Table(name = "sub_sub_sub_grupo_interes")
public class SubDeSubDeSubGrupoInteres implements Serializable {
	// --------------------------------
	// Constantes de la Clase.
	// --------------------------------

	/**
	 * Constante de Serialización.
	 */
	private static final long serialVersionUID = -6362794385792247263L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sub_sub_sub_grupo_interes", nullable = false)
	private long idSubSubGrupoInteres;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private String estado;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sub_sub_grupo_interes", nullable = true, updatable = true)
	private SubDeSubGrupoInteres subDeSubGrupoInteres;

	// --------------------------------
	// Constructor
	// --------------------------------

	public SubDeSubDeSubGrupoInteres() {
		super();
	}

	public SubDeSubDeSubGrupoInteres(long idSubSubGrupoInteres, String nombre, String estado,
			SubDeSubGrupoInteres subDeSubGrupoInteres) {
		this.idSubSubGrupoInteres = idSubSubGrupoInteres;
		this.nombre = nombre;
		this.estado = estado;
		this.subDeSubGrupoInteres = subDeSubGrupoInteres;
	}

	// -------------------------
	// Métodos de la clase
	// -------------------------
	public long getIdSubSubGrupoInteres() {
		return idSubSubGrupoInteres;
	}

	public void setIdSubSubGrupoInteres(long idSubSubGrupoInteres) {
		this.idSubSubGrupoInteres = idSubSubGrupoInteres;
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

	public SubDeSubGrupoInteres getSubDeSubGrupoInteres() {
		return subDeSubGrupoInteres;
	}

	public void setSubDeSubGrupoInteres(SubDeSubGrupoInteres subDeSubGrupoInteres) {
		this.subDeSubGrupoInteres = subDeSubGrupoInteres;
	}


	@Override
	public String toString() {
		return "SubDeSubDeSubGrupoInteres [idSubSubGrupoInteres=" + idSubSubGrupoInteres + ", nombre=" + nombre
				+ ", estado=" + estado + ", subDeSubGrupoInteres=" + subDeSubGrupoInteres + "]";
	}

}
