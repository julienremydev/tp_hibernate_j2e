package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.AbonneDAO;
import forum.Abonne;
import forum.Particulier;
import util.HibernateUtil;

public class TestAbonne {

	AbonneDAO dao = new AbonneDAO();
	Abonne abo;
	
	@BeforeClass
    public static void init() throws Exception {
        
    }
	@Test
    public void simple() {
		HibernateUtil.getSessionFactory()
        .getCurrentSession().beginTransaction();
		Abonne abonne = new Particulier("login", "mdp", "nom", "prenom");
		HibernateUtil.getSessionFactory()
        .getCurrentSession().save(abonne);

		HibernateUtil.getSessionFactory()
        .getCurrentSession().getTransaction().commit();
		
        Abonne abo = dao.rechercheParLoginAbonne("login", "mdp");
        assertNotNull(abo);
        assertEquals("login", abo.getLogin());
    }
}
