package com.eric.mtgproject.helpers;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardPrice;
import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.json.CardJson;
import com.eric.mtgproject.json.CardSetJson;
import com.eric.mtgproject.utils.HibernateUtils;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class PopulateDatabase {
	
	public static void populateDatabaseFromMTGJson(){
		
		Session session = HibernateUtils.getSession();
        Transaction t;
		
		try {

            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\json\\AllSetsArray.json"));
            CardSetJson[] cardSets = gson.fromJson(reader, CardSetJson[].class);
            
        	Query<?> querySets = session.createQuery("select setId from CardSet");
        	List<?> querySetsResults = querySets.getResultList();
            
        	Query<?> queryCards = session.createQuery("select cardId from Card");
        	List<?> queryCardsResults = queryCards.getResultList();
            
            /* Parse sets */
            for(int j=0; j<cardSets.length; j++){
            	
            	t = session.beginTransaction();
            	
            	Boolean insertSet = true;
            	CardSetJson jsonCardSet = cardSets[j];
            
            	if(querySetsResults.contains(jsonCardSet.getCode())){
            		System.out.println("Found set: " + jsonCardSet.getName() + ". Skipping Insert.");
            		insertSet = false;
            	}
            		
        		/* Create new set */
            	CardSet set = new CardSet();
            	
            	/* Set card set attributes */
            	set.setSetId(jsonCardSet.getCode());
            	set.setBlock(jsonCardSet.getBlock());
            	set.setBorder(jsonCardSet.getBorder());
	            set.setGathererCode(jsonCardSet.getGathererCode());
            	set.setMagicCardsInfoCode(jsonCardSet.getMagicCardsInfoCode());
            	set.setOldCode(jsonCardSet.getOldCode());
            	set.setReleaseDate(jsonCardSet.getReleaseDate());
            	set.setSetName(jsonCardSet.getName());
            	set.setSetType(jsonCardSet.getType());
            	if(jsonCardSet.getOnlineOnly() == null){
            		set.setOnlineOnly(false);
            	}else{
            		set.setOnlineOnly(jsonCardSet.getOnlineOnly());
            	}
            	
            	if(insertSet){
            		System.out.println("Saving SET: " + set.getSetName());
	            	/* Add set and commit */
	            	session.save(set);
	        		t.commit();
	            }
            	
            	/* Parse Cards in set */
            	List<CardJson> cards = jsonCardSet.getCards();
            	System.out.println("Number of cards: " + cards.size());
            	for(int k=0; k<cards.size(); k++){
            		
                	Boolean insertCard = true;            		
            		CardJson jsonCard = cards.get(k);
                	
                	if(queryCardsResults.contains(jsonCard.getId())){
                		System.out.println("Found card in database: " + jsonCard.getId() + ". Skipping Insert.");
                		insertCard = false;
                	}
            		Card card = new Card();
        		
            		card.setCardId(jsonCard.getId());
            		card.setArtist(jsonCard.getArtist());
            		card.setBorder(jsonCard.getBorder());
            		card.setCmc(jsonCard.getCmc());
            		card.setColorIdentity(jsonCard.getColorIdentity().toString());
            		card.setColors(jsonCard.getColors().toString());
            		card.setFlavor(jsonCard.getFlavor());
            		card.setImageName(jsonCard.getImageName());
            		card.setLayout(jsonCard.getLayout());
            		card.setLoyalty(jsonCard.getLayout());
            		card.setManaCost(jsonCard.getManaCost());
            		card.setMcinumber(jsonCard.getMciNumber());
            		card.setMultiverseId(jsonCard.getMultiverseid());
            		card.setName(jsonCard.getName());
            		card.setCardNames(jsonCard.getNames().toString());
            		card.setCardNumber(jsonCard.getNumber());
            		card.setCardPower(jsonCard.getPower());
            		card.setRarity(jsonCard.getRarity());
            		card.setReserved(jsonCard.getReserved());
            		card.setCardSet(set);
            		card.setSubtypes(jsonCard.getSubtypes().toString());
            		card.setSuperTypes(jsonCard.getSupertypes().toString());
            		card.setText(jsonCard.getText());
            		card.setTimeShifted(jsonCard.getTimeshifted());
            		card.setToughness(jsonCard.getToughness());
            		card.setCardType(jsonCard.getType());
            		card.setTypes(jsonCard.getTypes().toString());
            		card.setVariations(jsonCard.getVariations().toString());
            		card.setWatermark(jsonCard.getWatermark());

                	if(insertCard){
                		System.out.println("Saving CARD: " + card.getName());
    	            	/* Add card and commit */
    	            	session.save(card);
    	            }
            		
            	}
            	
            	t.commit();
        		
        	}
            
            System.out.println("Success!");

        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
           session.close();
        }

        session.close();

	}

	@SuppressWarnings("unchecked")
	public static void updatePriceTable(Map<String, String> cardListMap, String setName){
		
		Session session = HibernateUtils.getSession();
        Transaction t;
        
        try{
	        t = session.beginTransaction();
	        
        	Query<?> queryCardPrices = session.createQuery("from CardPrice where card.cardSet.setName = :setName");
        	queryCardPrices.setParameter("setName", setName);
        	List<CardPrice> queryCardsPricesResults = (List<CardPrice>) queryCardPrices.getResultList();
	        
	        //Get Cards from the set we want to update
	        List<Card> cardListDB = QueryDatabase.getCardsBySetName(setName);
	        
	        Card card = new Card();
	        Iterator<Entry<String, String>> entries = cardListMap.entrySet().iterator();
	        
	        int index = 0;
	        while (entries.hasNext()) {
	        	
				Entry<String, String> thisEntry = (Entry<String, String>) entries.next();
				Object cardName = thisEntry.getKey();
				Object cardPrice = thisEntry.getValue();
				
				Boolean foundCard = false;
				for(int j=0; j<cardListDB.size(); j++){
					if(cardName.toString().equals(cardListDB.get(j).getName())){
						card = cardListDB.get(j);
						foundCard = true;
						break;
					}
				}
				
				if(foundCard){
					
					//Change price to fit Database format.
					String cardPriceString = cardPrice.toString().substring(1).replace(",", "");						
					BigDecimal cardPriceBigDecimal = null;
					try{
						cardPriceBigDecimal = new BigDecimal(cardPriceString);
					}catch(NumberFormatException e){
						System.out.println("ERROR: Price N/A " + cardName.toString());
					}
					
					CardPrice cardPriceObject = new CardPrice();
					
		        	//Check if we need to update or insert.
		        	Boolean update = false;
	        		for(int k=0; k<queryCardsPricesResults.size(); k++){
	        			if(queryCardsPricesResults.get(k).getCard().getCardId().equals(card.getCardId())){
	        				cardPriceObject = (queryCardsPricesResults.get(k));
	                		cardPriceObject.setPrice(cardPriceBigDecimal);
	        				update = true;
	        			}
	        		}	        		

	            	if(!update){
	            		System.out.println("Insert new card: " + card.getName());
						cardPriceObject.setCard(card);
						cardPriceObject.setPrice(cardPriceBigDecimal);
	            	}
	            	
	            	session.save(cardPriceObject);

	                index++;
				}else{
					System.out.println("ERROR: Card not found " + cardName.toString());
				}
	       	}
	        
	        t.commit();
	        
        }catch(Exception e){
        	System.out.println("Error " + e.getMessage());
        	e.printStackTrace();
        	System.exit(0);
        }
	}
}
