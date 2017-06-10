package br.com.fiap.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("Atividade3Jpa");
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}