package forms;

import beans.User;
import dao.UserDao;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class AddUserForm {
	private static final String CHAMP_NOM = "lastName";
	private static final String CHAMP_PRENOM = "firstName";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "confirmPassword";
	private static final String FIELD_MESSAGE = "Please fill in this field";
	private static final String WRONG_PASSWORD = "Passwords are not the same";

	private HttpServletRequest request;
	private Map<String, String> errors;
	private boolean status;
	private String statusMessage;
	private User user;

	public AddUserForm(HttpServletRequest request) {

		this.status = false;
		this.request = request;
		this.errors = new HashMap<String, String>();
	}

	public boolean addUser() {
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);

		this.user = new User(nom, prenom, login, password);
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD, CHAMP_PASSWORD_BIS);
		validerPassword();

		if (errors.isEmpty()) {
			status = true;
			statusMessage = "user succesfully added";
			UserDao.addUser(user);

		}

		else {
			status = false;
			statusMessage = "Add user failed, please try again";

		}

		return status;
	}

	private String getParameter(String parametre) {
		String valeur = request.getParameter(parametre);

		return (valeur == null || valeur.trim().isEmpty()) ? null : valeur.trim();

	}

	private void validerChamps(String... parametres) {
		for (String parametre : parametres) {
			if (this.getParameter(parametre) == null) {
				errors.put(parametre, FIELD_MESSAGE);
			}
		}

	}

	private void validerPassword() {
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);

		if (password != null && !password.equals(passwordBis)) {
			errors.put(CHAMP_PASSWORD, WRONG_PASSWORD);
			errors.put(CHAMP_PASSWORD_BIS, WRONG_PASSWORD);

		}

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public boolean getStatus() {
		return status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public User getUser() {
		return user;
	}

}
