package com.eric.mtgproject.helpers;

import java.io.FileReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.json.CardSetJson;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class PopulateDatabase {
	
public static void populateDatabaseFromJson(){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
		
		try {

            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("D:\\workspace\\MTGProject\\WebContent\\WEB-INF\\json\\AllSetsArray.json"));
            CardSetJson[] arr = gson.fromJson(reader, CardSetJson[].class);
            
            
            
            for(int j=0; j<arr.length; j++){
            	
            	Query<?> query = session.createQuery("select setId from CardSet");
            	List<?> list = query.getResultList();
            	
            	if(list.contains(arr[j].getCode())){
            		System.out.println("Found set: " + arr[j].getCode() + ". Skipping Insert.");
            		
            	}else {
            		
	            	CardSet set = new CardSet();
	            	
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
	            	
	            	System.out.println("***************************");
	            	System.out.println("Saving set: " + arr[j].getName());
	            	System.out.println("***************************");
	            	session.save(set);
	            	t.commit();
            	}

            }
        } catch (Exception e) {
           System.out.println("Error " + e.getMessage());
           session.close();
        }

        session.close();

	}

}
