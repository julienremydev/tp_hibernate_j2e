package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import forum.*;

public class Main {


	public static void main(String[] args) {
	
	        Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
               Abonne abo = new Particulier("bat","mdp", "Baptiste", "Roux");
               
               session.save(abo);
                Message msgAbo = new Message("[ALERTE ROUGE]", "TRUMP est élu !!!");
                msgAbo.setAbonne(abo);
                session.save(msgAbo);
               Abonne abo2 = new Entreprise("batEntreprise","mdp", "raisonSociale");
               session.save(abo2);
		
                
               Annuaire annuaire = new Annuaire("annuaire1");
               annuaire.getTopic().add(abo);
               annuaire.getTopic().add(abo2);
               session.save(annuaire);
		
                
           
		tx.commit();
            
		
                
               
	    HibernateUtil.closeSession();
            HibernateUtil.getSessionFactory().close();
		}

	}

