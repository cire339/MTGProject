package com.eric.mtgproject.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static final Session session = createSession();
	
	private static Session createSession(){
		System.out.println("Entering createSession");
		if(session == null){
			System.out.println("Session Created.");
			return sessionFactory.openSession();
		}else{
			System.out.println("Session already exists.");
			return sessionFactory.getCurrentSession();
		}
	}
	
	private static SessionFactory buildSessionFactory() {
		System.out.println("Entering buildSessionFactory");
		if(sessionFactory == null){
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			System.out.println("SessionFactory Created.");
		    return cfg.buildSessionFactory();
		}else{
			System.out.println("SessionFactory already exists.");
			return sessionFactory;
		}
	}
	
	public static void closeSession() {
		sessionFactory.close();
	}

	public static Session getSession() {
		return session;
	}
	
	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}

}
