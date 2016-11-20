package com.eric.mtgproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.helpers.PopulateDatabase;
import com.eric.mtgproject.helpers.PriceScrapper;
import com.eric.mtgproject.helpers.QueryDatabase;

public class TestingClass {
		
	public static void main(String[] args){
		
		List<String> sets = Arrays.asList("Shards of Alara", "Conflux", "Alara Reborn", "Magic 2010 (M10)", 
				"Zendikar", "Worldwake", "Rise of the Eldrazi", "Magic 2011 (M11)", 
				"Scars of Mirrodin", "Mirrodin Besieged", "New Phyrexia", 
				"Magic 2012 (M12)", "Innistrad", "Dark Ascension", "Avacyn Restored", 
				"Magic 2013 (M13)", "Return to Ravnica", "Gatecrash", "Dragon's Maze", 
				"Magic 2014 (M14)", "Theros", "Born of the Gods", "Journey into Nyx", 
				"Magic 2015 (M15)", "Khans of Tarkir", "Fate Reforged", "Dragons of Tarkir", 
				"Magic Origins", "Battle for Zendikar", "Oath of the Gatewatch", 
				"Shadows over Innistrad", "Eldritch Moon", "Kaladesh");
		
		//Gets Sets we want to scrape
    	Map<String, String> cardList = new HashMap<String, String>();
    	
    	List<CardSet> cardSetList = QueryDatabase.getSets();
    	
		for(int i=0; i<sets.size(); i++){
			//String dbSetName = cardSetList.get(i).getSetName();
			//String tcgSetName = cardSetList.get(i).getTcgplayerSetName();
			
			//Get Prices from TCGPlayer
			cardList = PriceScrapper.scrapePrices(sets.get(i));
			
			//Insert Price in Database
			PopulateDatabase.updatePriceTable(cardList, sets.get(i));
		}
		
		System.out.println("Back in main.");
		
		System.exit(0);
		
	}

}
