package com.eric.mtgproject.controllers;

import org.springframework.web.servlet.mvc.Controller;

import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.helpers.QueryDatabase;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;

public class CardsSearchController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String cardName = request.getParameter("card");
    	
    	ModelAndView model = new ModelAndView("WEB-INF/jsp/Search.jsp");
    	
    	if(cardName.length() > 2){
    		List<Card> queryCardsResults = QueryDatabase.getCardsByName(cardName);
    		model.addObject("searchResult", queryCardsResults);
    	}
    	
    	return model;

    }

}