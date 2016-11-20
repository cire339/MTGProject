package com.eric.mtgproject.controllers;

import org.springframework.web.servlet.mvc.Controller;

import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardPrice;
import com.eric.mtgproject.helpers.QueryDatabase;
import com.eric.mtgproject.utils.HibernateUtils;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;

public class CardsController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String cardID = request.getParameter("card");
    	
    	ModelAndView model = new ModelAndView("WEB-INF/jsp/Cards.jsp");
    	
    	if(cardID != null){
    		List<Card> queryCardsResults = QueryDatabase.getCardsById(cardID);
    		CardPrice cardPrice = QueryDatabase.getPriceById(cardID);
    		if(queryCardsResults.size() == 1){
    			model.addObject("cardInfo", queryCardsResults.get(0));
    			model.addObject("cardPrice", cardPrice);
    		}else{
    			model = new ModelAndView("WEB-INF/jsp/errors/404.jsp");
    		}
    	}
    	
    	return model;

    }
    
    public void init() {
        //Create Hibernate Session
     	new HibernateUtils();
     }

}