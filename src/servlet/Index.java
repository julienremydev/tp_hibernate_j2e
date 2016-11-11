package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import forum.Abonne;
import forum.Particulier;
import util.HibernateUtil;

public class Index extends HttpServlet {
	public static final String ACCES_PUBLIC = "/WEB-INF/index.jsp";
	public static final String ACCES_RESTREINT = "/forum";
	public static final String SESSION_ABONNE = "sessionAbonne";

	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_MDP = "mdp";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_RAISONSOCIALE = "raisonSociale";

	private String message;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Abonne inscriptionParticulier(HttpServletRequest request) {
		/* Récupération des champs du formulaire */
		String login = getValeurChamp(request, CHAMP_LOGIN);
		String mdp = getValeurChamp(request, CHAMP_MDP);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);

		Abonne abonne = new Particulier(login, mdp, nom, prenom);

		return abonne;
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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Création d'un objet abonné dans la session si la connexion ou
		// l'inscription est valide
		if (request.getParameterMap().containsKey("connexion")) {

		} else if (request.getParameterMap().containsKey("inscriptionParticulier")) {
			Session sessionHibernate = HibernateUtil.currentSession();
			Transaction tx = sessionHibernate.beginTransaction();

			Abonne abo = inscriptionParticulier(request);
			sessionHibernate.save(abo);

			try {
				tx.commit();
				HttpSession session = request.getSession();
				session.setAttribute(SESSION_ABONNE, abo);
			} catch (org.hibernate.exception.ConstraintViolationException e) {
				message = "Le login est déjà utilisé.";
				request.setAttribute("message", message);
			}
		} else if (request.getParameterMap().containsKey("inscriptionEntreprise")) {

		}

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