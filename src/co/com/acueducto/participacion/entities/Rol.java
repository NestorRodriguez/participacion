package co.com.acueducto.participacion.entities;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries(value = { @NamedQuery(name = "Rol.FindAll", query = "SELECT r FROM Rol r ORDER BY r.nombre") })
@Table(name = "rol")
public class Rol implements Serializable{
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
		@Column(name = "id_rol", nullable = false)
		private long idRol;

		@Column(name = "nombre_rol", nullable = false)
		private String nombre;

		@Column(name = "menu", nullable = true)
		@Lob
		private byte[] menu;

		// --------------------------------
		// Constructor de la Clase.
		// --------------------------------

		/**
		 * Constructor por Defecto.
		 */
		public Rol() {
		}

		public Rol(String nombre, byte[] menu) {
			this.nombre = nombre;
			this.menu = menu;
		}

		public long getIdRol() {
			return idRol;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public byte[] getMenu() {
			return menu;
		}

		public void setMenu(byte[] menu) {
			this.menu = menu;
		}

		public void setIdRol(long idRol) {
			this.idRol = idRol;
		}

		@Override
		public String toString() {
			return "Rol [idRol=" + idRol + ", nombre=" + nombre + ", menu=" + Arrays.toString(menu) + "]";
		}

}
