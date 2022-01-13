package co.com.acueducto.participacion.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.acueducto.participacion.entities.Usuario;
import co.com.acueducto.participacion.resources.Mensaje;
import co.com.acueducto.participacion.serviceinterface.IUsuarioService;;

@Named
@SessionScoped
public class LogonMB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1635808543847340845L;

	private Usuario usuario;

	private Mensaje mensaje;

	@Inject
	private IUsuarioService usuarioService;

	@PostConstruct
	public void init() {
		System.out.println("logonMB.init");
		mensaje = new Mensaje();
		usuario = new Usuario();
	}

	@SuppressWarnings("unlikely-arg-type")
	public void login() throws IOException {
		System.out.println("logonMB.login");
		boolean estado = false;
		if (usuario.getCorreoElectronico() == null || usuario.getCorreoElectronico().trim().equals("")) {
			mensaje.warning("Alerta", "Correo vacio");
			estado = true;
		}
		if (usuario.getPassword() == null || usuario.getPassword().trim().equals("")) {
			mensaje.warning("Alerta", "Contraseña vacia");
			estado = true;
		}
		if (!estado) {
			// usuario.encriptar();
			usuario = usuarioService.buscarUserPass(usuario);
			if (usuario == null && usuario.equals("")) {
				mensaje.error("Error", "No se puede conectar en este momento");
			} else {
				if (usuario != null && usuario.getIdUsuario() != 0) {
					FacesContext facesContext = FacesContext.getCurrentInstance();
					ExternalContext externalContext = facesContext.getExternalContext();
					externalContext.getSessionMap().put("AUTHORIZED", usuario);
					externalContext.redirect("home/home.xhtml");
				} else
					mensaje.error("Error", "Usuario o password incorrectos o usuario no registrado!");
				usuario = new Usuario();
			}
		}
	}

	/*
	 * public void registrarse() throws IOException{
	 * System.out.println("logonMB.registrarse"); FacesContext facesContext =
	 * FacesContext.getCurrentInstance(); ExternalContext externalContext =
	 * facesContext.getExternalContext();
	 * externalContext.getSessionMap().put("AUTHORIZED", usuario);
	 * externalContext.redirect("registrar/registrar.xhtml"); }
	 */

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
