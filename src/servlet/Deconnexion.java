package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Deconnexion extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3362945275861110624L;
	public static final String ACCES_PUBLIC     = "/index";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* R�cup�ration et destruction de la session en cours */
		HttpSession session = request.getSession();
		session.invalidate();

		/* Redirection vers la page publique */
		response.sendRedirect(request.getContextPath() + ACCES_PUBLIC);
		}
}