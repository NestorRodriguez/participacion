package test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ClienteBean {
	static Logger log = LogManager.getRootLogger();
	
	@SuppressWarnings("unused")
	private static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myEntityManager");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		log.debug("inicio de transacciones");
		
		em.close();
		
	}
}
