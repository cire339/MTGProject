package com.eric.mtgproject.utils;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

public class ContextFinalizer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	//Close Hibernate Session
    	try{
    		HibernateUtils.closeSession();
    	}catch(Exception e){
    		System.out.println("SEVERE problem cleaning up Hibernate Session: " + e.getMessage());
            e.printStackTrace();
    	}
    	
    	//De-register JDBC Driver
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while(drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
                System.out.println(String.format("Driver %s deregistered", d));
            } catch (SQLException ex) {
                System.out.println(String.format("Error deregistering driver %s", d) + ex);
            }
        }
        try {
            AbandonedConnectionCleanupThread.shutdown();
        } catch (InterruptedException e) {
        	System.out.println("SEVERE problem cleaning up JDBC Driver: " + e.getMessage());
            e.printStackTrace();
        }
    }

}