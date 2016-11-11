package com.eric.mtgproject.helpers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.eric.mtgproject.db.Card;

public class QueryDatabase {
	
	public static void getCardsByName(String cardName){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
		
		try {
        	Query<?> queryCards = session.createQuery("from Card C where C.name = :name ");
        	queryCards.setParameter("name", cardName);
        	List<Card> queryCardsResults = (List<Card>) queryCards.getResultList();
        	
        	for(int i=0; i<queryCardsResults.size(); i++){
        		System.out.println(queryCardsResults.get(i).getName());
        		System.out.println(queryCardsResults.get(i).getCmc());
        	}
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }

	}
	
	public static void getCardsBySet(String setName){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
		
		try {
        	Query<?> queryCards = session.createQuery("from Card C where cardSet.setName = :setName");
        	queryCards.setParameter("setName", setName);
        	List<Card> queryCardsResults = (List<Card>) queryCards.getResultList();
        	
        	for(int i=0; i<queryCardsResults.size(); i++){
        		System.out.println(queryCardsResults.get(i).getName());
        		System.out.println(queryCardsResults.get(i).getCmc());
        	}
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }

	}

}
