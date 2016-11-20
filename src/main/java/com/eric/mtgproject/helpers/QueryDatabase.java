package com.eric.mtgproject.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardPrice;
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
        	Query<?> queryCards = session.createQuery("from Card C where cardSet.setId = :setId order by name");
        	queryCards.setParameter("setId", setId);
        	queryCardsResults = (List<Card>) queryCards.getResultList();
        	
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }
		
		return queryCardsResults;

	}
	
	@SuppressWarnings("unchecked")
	public static CardPrice getPriceById(String cardId){
		
		Session session = HibernateUtils.getSession();
		List<CardPrice> queryCardPriceResult = new ArrayList<CardPrice>();
		CardPrice cardPrice = new CardPrice();
	    
		try {
	    	Query<?> queryCards = session.createQuery("from CardPrice where card.cardId = :id ");
	    	queryCards.setParameter("id", cardId);
	    	queryCardPriceResult = (List<CardPrice>) queryCards.getResultList();
	    	if(queryCardPriceResult.size() == 1){
	    		cardPrice = queryCardPriceResult.get(0);
	    	}
	    	
	    } catch (Exception e) {
	       System.out.println("Error " + e.getMessage());
	    }
		
		return cardPrice;
	
	}
}
