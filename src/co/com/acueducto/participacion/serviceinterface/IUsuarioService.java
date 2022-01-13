package co.com.acueducto.participacion.serviceinterface;

import java.util.List;

import co.com.acueducto.participacion.entities.Usuario;

public interface IUsuarioService {

	public void registarUsuario(Usuario rol);

	public void actualizarUsuario(Usuario rol);

	public void eliminarUsuario(Long id);
	
	public Usuario buscarUsuarioxId(Long id);

	public List<Usuario> buscarUsuarios();

	public Usuario buscarUserPass(Usuario usuario);
}
