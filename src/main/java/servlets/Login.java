package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import beans.User;
import forms.LoginForm;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_USER = "/WEB-INF/connexion.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		LoginForm form = new LoginForm(request);

		if (form.login()) {
			// request.setAttribute(ATT_FORM, form);

			response.sendRedirect("list");
			// response.sendRedirect(request.getContextPath() + "/list");
			// response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("form", form);
			request.setAttribute("login", form.getLogin());
			request.setAttribute("status", form.isStatus());
			request.setAttribute("statusMessage", form.getStatusMessage());
			this.getServletContext().getRequestDispatcher(VUE_USER).forward(request, response);

		}

	}

}
