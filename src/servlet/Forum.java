package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Forum extends HttpServlet {
	public static final String ACCES_RESTREINT = "/zoneAbonne/forum.jsp";
	public static final String DECO = "/deco";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterMap().containsKey("deco")) {
			this.getServletContext().getRequestDispatcher(DECO).forward(request, response);
		}
		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher(ACCES_RESTREINT).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher(ACCES_RESTREINT).forward(request, response);

	}
}