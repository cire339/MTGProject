package com.eric.mtgproject.helpers;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.utils.HibernateUtils;

public class PriceScrapper {
	
	public static Map<String, String> scrapePrices(String setName){
		
		/*
		//Skip set if file already exists..!
		Path path = Paths.get("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\csv\\" + setName.replace(" ", "") + ".csv");
		if(Files.exists(path)){
			System.out.println("File already exists: " + path);
			return false;
		}
		*/
		
    	Map<String, String> cardList = new HashMap<String, String>();
		
	    try {
	    	System.out.println("setName: " + setName);
	    	Response response = Jsoup.connect("http://magic.tcgplayer.com/db/search_result.asp?Set_Name=" + URLEncoder.encode(setName, "UTF-8")).followRedirects(false).execute();
	    	if(response.statusCode() != 200 ){
				System.out.println("Error - Page not found or redirected");
				return cardList;
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
				return cardList;
			}
			
			for(int j=0; j<cards.size(); j++){
				cardInfo = cards.get(j).select("td");
				
				//If not regular card, skip it
				if( Arrays.asList(rarity).indexOf(cardInfo.get(3).text()) != -1 ){
					cardName = cardInfo.get(0);
					cardPrice = cardInfo.get(5);
					cardList.put(cardName.text().substring(1), cardPrice.text());
				}
			}
			
			/*
			//Write to file
			Path file = Paths.get("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\csv\\" + setName.replace(" ", "") + ".csv");
			Files.write(file, cardList, Charset.forName("UTF-8"));
			*/
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return cardList;
		  
	}

}
