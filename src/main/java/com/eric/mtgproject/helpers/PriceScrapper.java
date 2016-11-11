package com.eric.mtgproject.helpers;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PriceScrapper {
	
	public static boolean generateCsvSetPrices(String setName){
		
		//Skip set if file already exists..!
		Path path = Paths.get("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\csv\\" + setName.replace(" ", "") + ".csv");
		if(Files.exists(path)){
			System.out.println("File already exists: " + path);
			return false;
		}
		
	    try {
	    	List<String> cardList = new ArrayList<String>();
	    	Response response = Jsoup.connect("http://magic.tcgplayer.com/db/search_result.asp?Set_Name=" + URLEncoder.encode(setName, "UTF-8")).followRedirects(false).execute();
	    	if(response.statusCode() != 200 ){
				System.out.println("Error - Page not found or redirected");
				return false;
	    	}
	    	
			Document doc = Jsoup.connect("http://magic.tcgplayer.com/db/search_result.asp?Set_Name=" + URLEncoder.encode(setName, "UTF-8")).get();
			Elements tables = doc.select("table[width=540][style=\"font-size:11px\"][cellspacing=0][cellpadding=1]");
			Elements cards = tables.select("tr");
			Elements cardInfo;
			Element cardName; 
			Element cardPrice;
			String[] rarity = {"C", "U", "R", "M"};
			
			//Exit if more than one table returned.
			if(tables.size() != 1){
				System.out.println("Multiple tables found - cannot parse.");
				return false;
			}
			
			for(int i=0; i<cards.size(); i++){
				cardInfo = cards.get(i).select("td");
							
				//If not regular card, skip it
				if( Arrays.asList(rarity).indexOf(cardInfo.get(3).text()) != -1 ){
					cardName = cardInfo.get(0);
					cardPrice = cardInfo.get(5);
					cardList.add(cardName.text() + ";" + cardPrice.text());
				}
				
			}
			
			//Write to file
			Path file = Paths.get("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\csv\\" + setName.replace(" ", "") + ".csv");
			Files.write(file, cardList, Charset.forName("UTF-8"));
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Success gathering prices for set: " + setName);
	    return true;
		  
	}

}
