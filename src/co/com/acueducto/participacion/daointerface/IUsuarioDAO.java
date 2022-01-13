package co.com.acueducto.participacion.daointerface;

import java.util.List;

import co.com.acueducto.participacion.entities.Usuario;

public interface IUsuarioDAO {

	public void create(Usuario usuario);

	public void update(Usuario usuario);

	public Usuario findById(Long id);

	public void delete(Long id);

	public List<Usuario> findAll();

	public Usuario finbByUserPass(Usuario usuario);
	
}
