package com.eric.mtgproject.helpers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardPrice;
import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.utils.HibernateUtils;

public class QueryDatabase {
	
	/* 
	 * Format split and flip cards 
	 */
	private static List<Card> formatSpecialCards(List<Card> cards){
		
		//Fix split cards
		for(int i=0; i<cards.size(); i++){
			Card card = cards.get(i);
			String cardLayout = card.getLayout();
			//Determine if card is a split card.
			if(cardLayout.equals("split") || cardLayout.equals("double-faced")){
				String cardPart = card.getCardNumber().substring(card.getCardNumber().length() - 1);
				String[] cardNames = card.getCardNames().substring(1, card.getCardNames().length() - 1).split(", ");
				
				String newName = cardNames[0] + " // " + cardNames[1];
				if(cardLayout.equals("split")){
					newName = cardNames[0] + " // " + cardNames[1];
				}else if(cardLayout.equals("double-faced")){
					newName = cardNames[0];
				}
				cards.get(i).setName(newName);
					
				//Remove other parts
				if(cardPart.equals("b") || cardPart.equals("c") || cardPart.equals("d")){
					cards.remove(i);
					i--;
				}
			}
		}
		
		return cards;
	}
	
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
	public static List<CardSet> getSetsById(String setId){
    
		Session session = HibernateUtils.getSession();
	
        List<CardSet> querySetsResults = new ArrayList<CardSet>();
		
		try {
        	Query<?> querySets = session.createQuery("from CardSet S where S.setId = :setId ");
        	querySets.setParameter("setId", setId);
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
	public static List<Card> getCardsByName(String cardName){
		
		Session session = HibernateUtils.getSession();
	    List<Card> queryCardsResults = new ArrayList<Card>();
	    
		try {
	    	Query<?> queryCards = session.createQuery("select C from Card C, CardSet S where C.cardSet.setId = S.setId and S.setType in ('core', 'expansion') and C.name like :name order by C.name");
	    	queryCards.setParameter("name", "%" + cardName + "%");
	    	queryCardsResults = (List<Card>) queryCards.getResultList();
	    	
	    	for(int i=0;i <queryCardsResults.size();i++){
	    		System.out.println(queryCardsResults.get(i).getName());
	    	}
	    	
	    	queryCardsResults = formatSpecialCards(queryCardsResults);
	    	
	    	for(int i=0;i <queryCardsResults.size();i++){
	    		System.out.println(queryCardsResults.get(i).getName());
	    	}
	    	
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
        	
        	queryCardsResults = formatSpecialCards(queryCardsResults);
        	
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
        	
        	queryCardsResults = formatSpecialCards(queryCardsResults);
        	
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
