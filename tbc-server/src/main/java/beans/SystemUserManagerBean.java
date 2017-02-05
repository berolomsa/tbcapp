package beans;

import models.SystemUser;
import services.SystemUserManager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SystemUserManagerBean implements SystemUserManager{
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean checkUser(String username, String password) {
		Query query = em.createQuery("SELECT su from SystemUser su where su.username =:username AND su.password =:password");
		query.setParameter("username", username);
		query.setParameter("password", password);

		List<SystemUser> result = query.getResultList();
		return !result.isEmpty();
	}
}
