package br.com.alura.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
// o objetivo dessa classe é de isolar o processo de criação do EntityManager
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager(); 
	}
	
	
}
