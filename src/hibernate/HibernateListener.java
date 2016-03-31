package hibernate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener {
	   public void contextInitialized(ServletContextEvent event) {  
	        HibernateUtil.getSessionFactory(); 
	    }  
	  
	    public void contextDestroyed(ServletContextEvent event) {  
	    	HibernateUtil.shutdown();
	    }  
} 


