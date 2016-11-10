package util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory(); // Initialisation de la fabrique
	}

	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getSessionFactory().close(); // Fermeture
	}
}