package util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	static {
		try {
			// Création de la SessionFactory � partir de hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
				
		} catch (HibernateException ex) {

			System.out.println("Initial SessionFactory creation failed." + ex);
			throw new RuntimeException("Probl�me de configuration : " + ex.getMessage() );
		}
	}

	public static final ThreadLocal session = new ThreadLocal();

	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		// Ouvre une nouvelle Session, si ce Thread n'en a aucune
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
