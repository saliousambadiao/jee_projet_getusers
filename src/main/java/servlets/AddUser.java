package servlets;

import forms.AddUserForm;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;
import forms.AddUserForm;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/add")
public class AddUser extends HttpServlet {

	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/addUser.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AddUserForm form = new AddUserForm(request);
		if (form.addUser()) {
			response.sendRedirect(request.getContextPath() + "/list");

		} else {
			request.setAttribute("utilisateur", form.getUser());
			request.setAttribute("erreurs", form.getErrors());
			request.setAttribute("status", form.getStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);

		}
	}

}
