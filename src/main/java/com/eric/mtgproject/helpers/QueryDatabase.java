package com.eric.mtgproject.helpers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardSet;

public class QueryDatabase {
	
@SuppressWarnings("unchecked")
public static List<CardSet> getSets(){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        List<CardSet> querySetsResults = new ArrayList<CardSet>();
		
		try {
        	Query<?> querySets = session.createQuery("from CardSet S where setType in ('core', 'expansion') order by releaseDate");
        	querySetsResults = (List<CardSet>) querySets.getResultList();
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        } 
		
		return querySetsResults;
	}
	
	@SuppressWarnings("unchecked")
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
        } finally {
        	session.close();
        }

	}
	
	@SuppressWarnings("unchecked")
	public static List<Card> getCardsBySetName(String setName){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        List<Card> queryCardsResults = new ArrayList<Card>();
		
		try {
        	Query<?> queryCards = session.createQuery("from Card C where cardSet.setName = :setName");
        	queryCards.setParameter("setName", setName);
        	queryCardsResults = (List<Card>) queryCards.getResultList();
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        } finally {
        	session.close();
        }
		
		return queryCardsResults;

	}
	
	@SuppressWarnings("unchecked")
	public static List<Card> getCardsBySetId(String setId){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        List<Card> queryCardsResults = new ArrayList<Card>();
		
		try {
        	Query<?> queryCards = session.createQuery("from Card C where cardSet.setId = :setId");
        	queryCards.setParameter("setId", setId);
        	queryCardsResults = (List<Card>) queryCards.getResultList();
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        } finally {
        	session.close();
        }
		
		return queryCardsResults;

	}

}
