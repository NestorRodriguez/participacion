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
		@NamedQuery(name = "Usuario.consultarUsuarios", query = "SELECT f FROM Usuario f"),
		@NamedQuery(name = "Usuario.buscarUsuarioUserPass", query = "SELECT f FROM Usuario f WHERE f.correoElectronico = :correoElectronico AND f.password = :password"),
		@NamedQuery(name = "Usuario.buscarUsuarioEmail", query = "SELECT f FROM Usuario f WHERE f.correoElectronico = :correoElectronico"),
		@NamedQuery(name = "Usuario.buscarUsuarioIdentificacion", query = "SELECT f FROM Usuario f"),
	 })

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

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
	@Column(name = "id_usuario", nullable = false)
	private long idUsuario;

	@Column(name = "numero_celular", nullable = false)
	private String numeroCelular;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "nombres", nullable = false)
	private String nombres;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "correo_electronico", nullable = false)
	private String correoElectronico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_rol", nullable = true, updatable = true)
	private Rol rol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_grupo_poblacional", nullable = true, updatable = true)
	private GrupoPoblacional grupoPoblacional;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sub_grupo_interes", nullable = true, updatable = true)
	private SubGrupoInteres subGrupoInteres;
	
	@Column(name = "id_sub_de_sub_grupo_interes", nullable = false)
	private int id_sub_de_sub_grupo_interes;
	
	@Column(name = "id_sub_de_sub_de_sub_grupo_interes", nullable = false)
	private int id_sub_de_sub_de_sub_grupo_interes;
	// --------------------------------
	// Constructor de la Clase.
	// --------------------------------

	/**
	 * Constructor por Defecto.
	 */
	public Usuario() {
	}

	public Usuario(long idUsuario, String numero_celular, String usuario, String password, String nombres,
			String apellidos, String correoElectronico, Rol rol) {
		this.idUsuario = idUsuario;
		this.numeroCelular = numero_celular;
		this.password = password;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correoElectronico = correoElectronico;
		this.rol = rol;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public GrupoPoblacional getGrupoPoblacional() {
		return grupoPoblacional;
	}

	public void setGrupoPoblacional(GrupoPoblacional grupoPoblacional) {
		this.grupoPoblacional = grupoPoblacional;
	}
	
	public SubGrupoInteres getSubGrupoInteres() {
		return subGrupoInteres;
	}

	public void setSubGrupoInteres(SubGrupoInteres subGrupoInteres) {
		this.subGrupoInteres = subGrupoInteres;
	}

	public int getId_sub_de_sub_grupo_interes() {
		return id_sub_de_sub_grupo_interes;
	}

	public void setId_sub_de_sub_grupo_interes(int id_sub_de_sub_grupo_interes) {
		this.id_sub_de_sub_grupo_interes = id_sub_de_sub_grupo_interes;
	}

	public int getId_sub_de_sub_de_sub_grupo_interes() {
		return id_sub_de_sub_de_sub_grupo_interes;
	}

	public void setId_sub_de_sub_de_sub_grupo_interes(int id_sub_de_sub_de_sub_grupo_interes) {
		this.id_sub_de_sub_de_sub_grupo_interes = id_sub_de_sub_de_sub_grupo_interes;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", numeroCelular=" + numeroCelular + ", password=" + password
				+ ", nombres=" + nombres + ", apellidos=" + apellidos + ", correoElectronico=" + correoElectronico
				+ ", rol=" + rol + ", grupoPoblacional=" + grupoPoblacional + ", subGrupoInteres=" + subGrupoInteres
				+ ", id_sub_de_sub_grupo_interes=" + id_sub_de_sub_grupo_interes
				+ ", id_sub_de_sub_de_sub_grupo_interes=" + id_sub_de_sub_de_sub_grupo_interes + "]";
	}

}
