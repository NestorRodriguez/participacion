package co.com.acueducto.participacion.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.eclipse.persistence.exceptions.DatabaseException;

import co.com.acueducto.participacion.daointerface.IUsuarioDAO;
import co.com.acueducto.participacion.entities.Usuario;
import co.com.acueducto.participacion.serviceinterface.IUsuarioService;

@Stateless
public class UsuarioService implements IUsuarioService {

	@Inject
	private IUsuarioDAO usuarioDAO;
	
	@Override
	public void registarUsuario(Usuario usuario) {
		try {
			usuarioDAO.create(usuario);	
		} catch (DatabaseException e) {
			System.out.println(
					"Error al registrar usuario " + e.getMessage() + " : " + e.getCause().getMessage());
		}
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		try {
			usuarioDAO.update(usuario);
		} catch (DatabaseException e) {
			System.out.println(
					"Error al actualizar usuario " + e.getMessage() + " : " + e.getCause().getMessage());
		}
	}

	@Override
	public void eliminarUsuario(Long id) {
		try {
			usuarioDAO.delete(id);
		} catch (DatabaseException e) {
			System.out.println(
					"Error al eliminar usuario " + e.getMessage() + " : " + e.getCause().getMessage());
		}
	}

	@Override
	public Usuario buscarUsuarioxId(Long id) {
		try {
			return usuarioDAO.findById(id);
		} catch (DatabaseException e) {
			System.out.println(
					"Error al buscar el usuario " + e.getMessage() + " : " + e.getCause().getMessage());
			return null;
		}
	}

	@Override
	public List<Usuario> buscarUsuarios() {
		try {
			return usuarioDAO.findAll();
		} catch (DatabaseException e) {
			System.out.println(
					"Error al buscar los  usuarios " + e.getMessage() + " : " + e.getCause().getMessage());
			return null;
		}
		
	}

	@Override
	public Usuario buscarUserPass(Usuario usuario) {
		try {
			Usuario user = usuarioDAO.finbByUserPass(usuario);
			if(user != null)
				return user;
			else
				return new Usuario();
		} catch (DatabaseException e) {
			System.out.println(
					"Error al buscar el usuario y password usuario " + e.getMessage() + " : " + e.getCause().getMessage());
			return null;
		}
			
	}

}
