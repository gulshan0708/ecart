package com.gk.ecart.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory emf;
	
	static {
		emf=Persistence.createEntityManagerFactory("com.gk.ecart");
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public void close() {
		emf.close();
	}
}
