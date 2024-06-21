package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import beans.User;
import dao.ConnectUser;

/**
 * Servlet implementation class UserAuthentification
 */
@WebServlet("/authentifierUser")
public class UserAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_USER = "/WEB-INF/connexion.jsp";
	private static final String ATT_FORM = "form";
	private static final String ATT_USER = "utilisateur";
	private static final String ATT_SESSION_USER = "sessionUser";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAuthentification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConnectUser form = new ConnectUser();
		User utilisateur = form.connectUser(request);
		HttpSession session = request.getSession();

		if (form.isStatus()) {
			request.setAttribute(ATT_FORM, form);
			response.sendRedirect("list");
		} else {

			request.setAttribute(ATT_SESSION_USER, null);
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_USER, utilisateur);

		}

		this.getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);
	}

}
