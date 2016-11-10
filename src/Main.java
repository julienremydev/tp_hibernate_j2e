
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import vins.Buveur;
import vins.Producteur;
import vins.*;

public class Main {


	public static void main(String[] args) {
	
	        Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
               Vin unVin = new Vin("bordeau",2007, 14, (float) 15.0);
               unVin.setNumero(new Long(1));
               session.save(unVin);
                
		VinConsommable unVin2 = new VinConsommable ("bordeau superieur",2006, 14,  (float) 5.0);
		VinDeGarde unVin3 = new VinDeGarde("bordeau",1992, 14,  (float) 500.0,6,4);
              
              //  unVin2.setNumero(new Long(1));
		session.save(unVin2);
                
              //  unVin3.setNumero(new Long(3));
		session.save(unVin3);
		

                Buveur unBuveur1 = new Buveur("Halin", "Gilles");
	        session.save(unBuveur1);
		unBuveur1.getAbu().add(unVin3);
	        unBuveur1.getAbu().add(unVin2);
                
		Producteur unProd = new Producteur("Nicolas", "Nancy");
		session.save(unProd);
		//unProd.getLesVins().add(unVin);
		//unProd.getLesVins().add(unVin2);
                //unProd.getLesVins().add(unVin3);
                unVin2.setProducteur(unProd);
                unVin3.setProducteur(unProd);
		
                
		List <Vin> vins = session.createQuery("from Vin").list();
                
           
		tx.commit();
            for (Object vin : vins) {
                Vin aVin = (Vin) vin;
                System.out.println("Vin : " + aVin.getNom() +
                        " annnee : " + aVin.getAnnee() + "nb bouteilles : " + aVin.getNbBouteilles()+ " prix : "+ aVin.getPrix() +" Prod : "+aVin.getProducteur().getNom());
            }
		
                
               
	    HibernateUtil.closeSession();
            HibernateUtil.getSessionFactory().close();
		}

	}

