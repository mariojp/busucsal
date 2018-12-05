package br.ucsal.busucsal.dao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;

/**
 * Application Lifecycle Listener implementation class HSQLBanco
 *
 */

@WebListener
public class HSQLBanco implements ServletContextListener {

	
    private Server server;

    /**
     * Default constructor. 
     */
    public HSQLBanco() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	server.shutdown();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        try {
            System.out.println("Starting Database");
            HsqlProperties p = new HsqlProperties();
            p.setProperty("server.database.0", "file:busucsal.db");
            p.setProperty("server.dbname.0", "busucsal");
            p.setProperty("server.port", "9001");
            server = new Server();
            server.setProperties(p);
            server.start();
            
        } catch (Exception e) {
        	System.out.println(e);
        }
    }
	
}
