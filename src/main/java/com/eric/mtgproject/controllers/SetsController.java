package com.eric.mtgproject.controllers;

import org.springframework.web.servlet.mvc.Controller;

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

    	ModelAndView model = new ModelAndView("WEB-INF/jsp/Sets.jsp");
    	
    	List<CardSet> querySetsResults = QueryDatabase.getSets();
    	
    	model.addObject("lists", querySetsResults);
    	
    	return model;

    }

}