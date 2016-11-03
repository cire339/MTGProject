package com.eric.mtgproject;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.json.CardSet;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class CardPriceScrapper {
	
	private static boolean queryDB(){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        // creating seession factory object
        SessionFactory factory = cfg.buildSessionFactory();

        // creating session object
        Session session = factory.openSession();

        // creating transaction object
        Transaction t = session.beginTransaction();

        Query<Card> query = session.createQuery("from Card");
        java.util.List<Card> list = query.getResultList();
        try{
	        System.out.println(list.size());
	        //System.out.println(list.get(0).getCardId());
        }catch(Exception e){
	        t.commit();
	        session.close();
        }
        t.commit();
        session.close();
		
		return true;
	}
	
	private static boolean getCard(String cardName){
		
		try {

            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\json\\AllSetsArray.json"));
            CardSet[] arr = gson.fromJson(reader, CardSet[].class);
            
            for(int j=0; j<arr.length; j++){
            	System.out.println("Set Name: " + arr[j].getName());
            	for(int k=0; k<arr[j].getCards().size(); k++){
            		//System.out.println("	" + arr[j].getCards().get(k).getLoyalty());
            	}
            }
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }
	    
		return true;
	}
	
	private static boolean generateCsvSetPrices(String setName){
		
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
		
		for(int i=0; i<sets.size();i++){
			//generateCsvSetPrices(sets.get(i));
		}
		
		//getCard("allo");
		queryDB();
	}

}
