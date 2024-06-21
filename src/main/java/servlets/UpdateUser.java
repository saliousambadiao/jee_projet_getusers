package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/update")
public class UpdateUser extends HttpServlet {

	private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/updateUser.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (id != null && id.matches("[0-9]+")) {
			User utilisateur = UserDao.get(Integer.parseInt(id));

			if (utilisateur != null) {
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
				return;
			}
		}

		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String lastName = request.getParameter("nom");
		String firstName = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (id != null && id.matches("[0-9]+")) {
			User user = new User(Integer.parseInt(id), lastName, firstName, login, password);
			UserDao.update(user);
		}

		response.sendRedirect(request.getContextPath());
	}

}
