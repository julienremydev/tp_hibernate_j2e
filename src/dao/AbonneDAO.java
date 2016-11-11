package dao;

import forum.Abonne;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;




public class AbonneDAO {

	@SuppressWarnings("unchecked")
	public Abonne rechercheParLoginAbonne(String login, String mdp) {
		

		List<Abonne> abonne = new ArrayList<Abonne>();
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		
		abonne = HibernateUtil.sessionFactory.getCurrentSession().createQuery("from Abonne where login=? and mdp=?")
				.setParameter(0, login).setParameter(1, mdp).list();
		
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		if (abonne.size() > 0) {
			return abonne.get(0);
		} else {
			return null;
		}

	}

}
