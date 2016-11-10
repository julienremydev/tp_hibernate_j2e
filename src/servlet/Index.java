package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {
	public static final String ACCES_PUBLIC     = "/index";
    public static final String ACCES_RESTREINT  = "/WEB-INF/forum.jsp";
    public static final String SESSION_ABONNE = "sessionAbonne";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Création d'un objet abonné dans la session si la connexion ou l'inscription est valide
		if (request.getParameterMap().containsKey("connexion")) {
			
		} else if (request.getParameterMap().containsKey("inscriptionParticulier")) {

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
			response.sendRedirect(request.getContextPath() + ACCES_PUBLIC);
		} else {
			/* Affichage de la page restreinte */
			this.getServletContext().getRequestDispatcher("/WEB-INF/forum.jsp").forward(request, response);
		}

	}
}