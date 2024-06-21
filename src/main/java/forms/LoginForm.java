package forms;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import beans.User;
import dao.UserDao;

public class LoginForm {
	private String CHAMP_LOGIN = "login";
	private String CHAMP_PASSWORD = "password";
	private boolean status;
	private String statusMessage;
	private User user;
	private HttpServletRequest request;
	private String login;

	public LoginForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = "failed";
	}

	public boolean login() {
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);

		User user = UserDao.getLogin(login);

		if (user != null && user.getPassword().equals(password)) {
			status = true;
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);

		}
		return status;
	}

	public String getParameter(String parametre) {
		String valeur = request.getParameter(parametre);
		return (valeur == null || valeur.trim().isEmpty()) ? null : valeur.trim();
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public User getUser() {
		return user;
	}

	public Object getLogin() {
		return login;
	}
}
