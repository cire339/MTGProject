package com.eric.mtgproject.helpers;

import java.io.FileReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.json.CardJson;
import com.eric.mtgproject.json.CardSetJson;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class PopulateDatabase {
	
public static void populateDatabaseFromJson(){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
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

}
