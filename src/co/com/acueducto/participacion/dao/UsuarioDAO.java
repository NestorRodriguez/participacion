package co.com.acueducto.participacion.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.com.acueducto.participacion.daointerface.IUsuarioDAO;
import co.com.acueducto.participacion.entities.Usuario;;

@Stateless
public class UsuarioDAO implements IUsuarioDAO {

	@PersistenceContext(unitName = "myEntityManager")
	EntityManager entity;

	// Crear usuario
	public void create(Usuario usuario) {
		entity.persist(usuario);
	}

	// editar usuario
	public void update(Usuario usuario) {
		entity.merge(usuario);
	}

	// buscar usuario por id
	public Usuario findById(Long id) {
		return entity.find(Usuario.class, id);
	}

	/// eliminar usuario
	public void delete(Long id) {
		entity.remove(entity.merge(id));
	}

	// obtener todos los usuario
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		return entity.createNamedQuery("Usuario.consultarUsuarios").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario finbByUserPass(Usuario usuario) {
		TypedQuery<Usuario> query = (TypedQuery<Usuario>) entity.createNamedQuery("Usuario.buscarUsuarioUserPass");
		List<Usuario> users = query.setParameter("correoElectronico", usuario.getCorreoElectronico())
				.setParameter("password", usuario.getPassword()).getResultList();
		if (users.size() == 0)
			return null;
		else
			return users.get(0);
	}
}
