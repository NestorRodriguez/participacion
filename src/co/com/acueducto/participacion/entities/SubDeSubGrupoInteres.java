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
		@NamedQuery(name = "SubDeSubGrupoInteres.FindAll", query = "SELECT sgi FROM SubDeSubGrupoInteres sgi ORDER BY sgi.nombre"),
		@NamedQuery(name = "SubDeSubGrupoInteres.buscarSubDeSubGrupoInteresByIdGrupoInteres", query = "SELECT sgi FROM SubDeSubGrupoInteres sgi WHERE sgi.subGrupoInteres.idSubGrupoInteres = :idSubGrupoInteres"),
})

@Entity
@Table(name = "sub_sub_grupo_interes")
public class SubDeSubGrupoInteres implements Serializable {
	// --------------------------------
	// Constantes de la Clase.
	// --------------------------------

	/**
	 * Constante de Serialización.
	 */
	private static final long serialVersionUID = -6362794385792247263L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sub_sub_grupo_interes", nullable = false)
	private long idSubSubGrupoInteres;
	

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private String estado;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sub_grupo_interes", nullable = true, updatable = true)
	private SubGrupoInteres subGrupoInteres;

	// --------------------------------
	// Constructor
	// --------------------------------
	
	public SubDeSubGrupoInteres(long idSubSubGrupoInteres, String nombre, String estado, SubGrupoInteres subGrupoInteres) {
		this.idSubSubGrupoInteres = idSubSubGrupoInteres;
		this.nombre = nombre;
		this.estado = estado;
		this.subGrupoInteres = subGrupoInteres;
	}

	public SubDeSubGrupoInteres() {
		super();
	}
	
	//-------------------------
	//Métodos de la clase
	//-------------------------

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

	public SubGrupoInteres getSubGrupoInteres() {
		return subGrupoInteres;
	}

	public void setSubGrupoInteres(SubGrupoInteres subGrupoInteres) {
		this.subGrupoInteres = subGrupoInteres;
	}

	@Override
	public String toString() {
		return "SubDeSubGrupoInteres [idSubSubGrupoInteres=" + idSubSubGrupoInteres + ", nombre=" + nombre + ", estado="
				+ estado + ", subGrupoInteres=" + subGrupoInteres + "]";
	}

}
