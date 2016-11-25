package com.eric.mtgproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.helpers.PopulateDatabase;
import com.eric.mtgproject.helpers.PriceScrapper;
import com.eric.mtgproject.helpers.QueryDatabase;

public class TestingClass {
		
	public static void main(String[] args){
				
		//Gets Sets we want to scrape
    	Map<String, String> cardList = new HashMap<String, String>();
    	List<CardSet> cardSetList = QueryDatabase.getSets();

		for(int i=0; i<cardSetList.size(); i++){
			String dbSetName = cardSetList.get(i).getSetName();
			String tcgSetName = cardSetList.get(i).getTcgplayerSetName();
			
			//Get Prices from TCGPlayer
			cardList = PriceScrapper.scrapePrices(tcgSetName);
			
			//Insert Price in Database
			PopulateDatabase.updatePriceTable(cardList, dbSetName);
		}
    	
		System.out.println("Back in main.");
		
		System.exit(0);
		
	}

}
