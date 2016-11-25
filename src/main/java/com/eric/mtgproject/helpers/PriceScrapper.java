package com.eric.mtgproject.helpers;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PriceScrapper {
	
	public static Map<String, String> scrapePrices(String setName){
		
    	Map<String, String> cardList = new HashMap<String, String>();
		
	    try {
	    	System.out.println("setName: " + setName);
	    	Response response = Jsoup.connect("http://prices.tcgplayer.com/price-guide/magic/" + URLEncoder.encode(setName.toLowerCase(), "UTF-8")).followRedirects(false).execute();
	    	if(response.statusCode() != 200 ){
				System.out.println("Error - Page not found or redirected");
				return cardList;
	    	}
	    	
			Document doc = Jsoup.connect("http://prices.tcgplayer.com/price-guide/magic/" + URLEncoder.encode(setName.toLowerCase(), "UTF-8")).get();
			Elements tables = doc.getElementsByClass("priceGuideTable tablesorter");
			Elements cards = tables.select("tbody").select("tr");
			String cardName; 
			String cardType;
			String cardPrice;
			String[] rarity = {"C", "U", "R", "M", "L"};
			
			//Exit if more than one table returned.
			if(tables.size() != 1){
				System.out.println("Multiple tables found - cannot parse.");
				return cardList;
			}
			
			for(int j=0; j<cards.size(); j++){
				
				cardName = cards.get(j).select("td[class=product]").select("div[class=productDetail]").select("a").text();
				cardType = cards.get(j).select("td[class=rarity]").select("div").text();
				cardPrice = cards.get(j).select("td[class=medianPrice]").select("div").text();
				
				//If price is missing, try market price.
				if(cardPrice.equals("—")){
					cardPrice = cards.get(j).select("td[class=marketPrice]").select("div").text();
				}
				
				//System.out.println("Name: " + cardName + ", Type: " + cardType + ", Price: " + cardPrice);
				
				//If not regular card, skip it
				if( Arrays.asList(rarity).indexOf(cardType) != -1 ){
					cardList.put(cardName, cardPrice);
				}
			}
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return cardList;
		  
	}

}
