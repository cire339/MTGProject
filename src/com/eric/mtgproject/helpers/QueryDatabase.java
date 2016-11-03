package com.eric.mtgproject.helpers;

import java.io.FileReader;

import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.json.CardSetJson;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class QueryDatabase {
	
	public static void getCard(String cardName){
		
		CardSet set = new CardSet();
		
		try {

            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\json\\AllSetsArray.json"));
            CardSetJson[] arr = gson.fromJson(reader, CardSetJson[].class);
            
            for(int j=0; j<arr.length; j++){
            	
            	System.out.println("SetID: " + arr[j].getCode());
            	set.setSetId(arr[j].getCode());
            	
            	System.out.println("Block: " + arr[j].getBlock());
            	set.setBlock(arr[j].getBlock());
            	
            	System.out.println("Border: " + arr[j].getBorder());
            	set.setBorder(arr[j].getBorder());
            	
            	System.out.println("GathererCode: " + arr[j].getGathererCode());
            	set.setGathererCode(arr[j].getGathererCode());
            	
            	System.out.println("MagicCardsInfoCode: " + arr[j].getMagicCardsInfoCode());
            	set.setMagicCardsInfoCode(arr[j].getMagicCardsInfoCode());
            	
            	System.out.println("OldCode: " + arr[j].getOldCode());
            	set.setOldCode(arr[j].getOldCode());

            	System.out.println("OnlineOnly: " + arr[j].getOnlineOnly());
            	if(arr[j].getOnlineOnly() == null){
            		set.setOnlineOnly(false);
            	}else{
            		set.setOnlineOnly(arr[j].getOnlineOnly());
            	}
            	
            	System.out.println("ReleaseDate: " + arr[j].getReleaseDate());
            	set.setReleaseDate(arr[j].getReleaseDate());
            	
            	System.out.println("SetName: " + arr[j].getName());
            	set.setSetName(arr[j].getName());
            	
            	System.out.println("SetType: " + arr[j].getType());
            	set.setSetType(arr[j].getType());

            }
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
        }

	}

}
