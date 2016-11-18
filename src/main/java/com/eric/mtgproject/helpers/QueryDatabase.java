package com.eric.mtgproject.helpers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.utils.HibernateUtils;

public class QueryDatabase {
	
@SuppressWarnings("unchecked")
public static List<CardSet> getSets(){
    
		Session session = HibernateUtils.getSession();
	
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
	public static List<Card> getCardsById(String cardId){
		
		Session session = HibernateUtils.getSession();
	    List<Card> queryCardsResults = new ArrayList<Card>();
	    
		try {
	    	Query<?> queryCards = session.createQuery("from Card C where C.cardId = :id ");
	    	queryCards.setParameter("id", cardId);
	    	queryCardsResults = (List<Card>) queryCards.getResultList();
	    	
	    } catch (Exception e) {
	       System.out.println("Error " + e.getMessage());
	    }
		
		return queryCardsResults;
	
	}
	
	@SuppressWarnings("unchecked")
	public static List<Card> getCardsBySetName(String setName){
		
		Session session = HibernateUtils.getSession();
        List<Card> queryCardsResults = new ArrayList<Card>();
		
		try {
        	Query<?> queryCards = session.createQuery("from Card C where cardSet.setName = :setName");
        	queryCards.setParameter("setName", setName);
        	queryCardsResults = (List<Card>) queryCards.getResultList();
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }
		
		return queryCardsResults;

	}
	
	@SuppressWarnings("unchecked")
	public static List<Card> getCardsBySetId(String setId){
		
		Session session = HibernateUtils.getSession();
        List<Card> queryCardsResults = new ArrayList<Card>();
		
		try {
        	Query<?> queryCards = session.createQuery("from Card C where cardSet.setId = :setId");
        	queryCards.setParameter("setId", setId);
        	queryCardsResults = (List<Card>) queryCards.getResultList();
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }
		
		return queryCardsResults;

	}

}
