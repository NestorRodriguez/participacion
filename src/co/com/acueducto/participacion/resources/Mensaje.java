/**
 * 
 */
package co.com.acueducto.participacion.resources;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 */
public class Mensaje {

	// --------------------------------
	// Constructor de la clase.
	// --------------------------------

	/**
	 * Constructor por defecto.
	 */
	public Mensaje() {
	}

	// --------------------------------
	// M�todos de la clase.
	// --------------------------------

	/**
	 * 
	 * @param titulo
	 * @param mensaje
	 */
	public void info(String titulo, String mensaje) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, mensaje);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	/**
	 * 
	 * @param titulo
	 * @param mensaje
	 */
	public void error(String titulo, String mensaje) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, mensaje);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	/**
	 * 
	 * @param titulo
	 * @param mensaje
	 */
	public void warning(String titulo, String mensaje) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, mensaje);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

}
