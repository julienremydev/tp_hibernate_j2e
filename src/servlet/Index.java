package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.AbonneDAO;
import forum.Abonne;
import forum.Entreprise;
import forum.Particulier;
import util.HibernateUtil;

public class Index extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7884806023808465959L;
	public static final String ACCES_PUBLIC = "/WEB-INF/index.jsp";
	public static final String ACCES_RESTREINT = "/forum";
	public static final String SESSION_ABONNE = "sessionAbonne";

	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_MDP = "mdp";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_RAISONSOCIALE = "raisonSociale";

	
	private AbonneDAO abonneDAO = new AbonneDAO ();
	private String message ;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		message="";
		redirection(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		message ="";
		// Création d'un objet abonné dans la session si la connexion ou
		// l'inscription est valide
		if (request.getParameterMap().containsKey("connexion")) {
			connexion(request);
		} else if (request.getParameterMap().containsKey("inscriptionParticulier")) {
			inscriptionParticulier(request);
		} else if (request.getParameterMap().containsKey("inscriptionEntreprise")) {
			inscriptionEntreprise(request);
		}

		redirection(request, response);
	}
	
	
	private void connexion(HttpServletRequest request) {

		/* Récupération des champs du formulaire */
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String mdp = getValeurChamp(request, CHAMP_MDP);

		if (login == null || mdp == null ) {
			message = "Les champs ne doivent pas être vide.";
		} else {
			
			Abonne abonne = abonneDAO.rechercheParLoginAbonne(login,mdp);
				if (abonne == null ){
					message = "Identifiants incorrects.";
				}else{
					HttpSession session = request.getSession();
					session.setAttribute(SESSION_ABONNE, abonne);
				}
				
		}

	}
	
	private void inscriptionParticulier(HttpServletRequest request) {

		/* Récupération des champs du formulaire */
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String mdp = getValeurChamp(request, CHAMP_MDP);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);

		if (login == null || mdp == null || nom == null || prenom == null) {
			message = "Les champs ne doivent pas être vide.";
		} else {
			try {
				HibernateUtil.getSessionFactory()
                .getCurrentSession().beginTransaction();
				Abonne abonne = new Particulier(login, mdp, nom, prenom);
				HibernateUtil.getSessionFactory()
                .getCurrentSession().save(abonne);

				HibernateUtil.getSessionFactory()
                .getCurrentSession().getTransaction().commit();
				HttpSession session = request.getSession();
				session.setAttribute(SESSION_ABONNE, abonne);
				
			} catch (org.hibernate.exception.ConstraintViolationException e) {
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
				message = "Le login est déjà utilisé.";
			}
		}

	}

	private void inscriptionEntreprise(HttpServletRequest request) {

		/* Récupération des champs du formulaire */
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String mdp = getValeurChamp(request, CHAMP_MDP);
		String raisonSociale = getValeurChamp(request, CHAMP_RAISONSOCIALE);

		if (login == null || mdp == null || raisonSociale == null) {
			message = "Les champs ne doivent pas être vide.";
		} else {
			try {
				HibernateUtil.getSessionFactory()
                .getCurrentSession().beginTransaction();
				Abonne abonne = new Entreprise(login, mdp, raisonSociale);
				HibernateUtil.getSessionFactory()
                .getCurrentSession().save(abonne);

				HibernateUtil.getSessionFactory()
                .getCurrentSession().getTransaction().commit();
				HttpSession session = request.getSession();
				session.setAttribute(SESSION_ABONNE, abonne);
				
			} catch (org.hibernate.exception.ConstraintViolationException e) {
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
				message = "Le login est déjà utilisé.";
			}
		}

	}
	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}

	

	public void redirection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Ajout de l'objet message dans la requête */
		request.setAttribute("message", message);

		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();

		/*
		 * Si l'objet abonné n'existe pas dans la session en cours, alors
		 * l'abonné n'est pas connecté.
		 */
		if (session.getAttribute(SESSION_ABONNE) == null) {
			/* Redirection vers la page publique */
			this.getServletContext().getRequestDispatcher(ACCES_PUBLIC).forward(request, response);
		} else {
			/* Affichage de la page restreinte */
			this.getServletContext().getRequestDispatcher(ACCES_RESTREINT).forward(request, response);
		}
	}
}