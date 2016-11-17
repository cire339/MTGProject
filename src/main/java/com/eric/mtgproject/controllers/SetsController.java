package com.eric.mtgproject.controllers;

import org.springframework.web.servlet.mvc.Controller;

import com.eric.mtgproject.db.Card;
import com.eric.mtgproject.db.CardSet;
import com.eric.mtgproject.helpers.QueryDatabase;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.List;

public class SetsController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
    	String setID = request.getParameter("set");
    	
    	ModelAndView model = new ModelAndView("WEB-INF/jsp/Sets.jsp");
    	
    	if(setID == null){
	    	List<CardSet> querySetsResults = QueryDatabase.getSets();
	    	model.addObject("setList", querySetsResults);
    	}else{
    		List<Card> queryCardsResults = QueryDatabase.getCardsBySetId(setID);
    		model.addObject("cardList", queryCardsResults);
    	}
    	
    	return model;

    }

}