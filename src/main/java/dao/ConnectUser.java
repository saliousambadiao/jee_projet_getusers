package dao;
import beans.User;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

public class ConnectUser {
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	public String getresult() {
		return result;
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public User connectUser(HttpServletRequest request) {
		String login = getParameter(request, CHAMP_LOGIN);
		String password = getParameter(request, CHAMP_PASSWORD);
		User user = new User();
		
		try {
			confirmLogin(login);
		} catch (Exception e) {
			setError(CHAMP_LOGIN, e.getMessage());
		}
		user.setLogin(login);
		
		try {
			confirmPassword(password);
			
		} catch(Exception e) {
			setError(CHAMP_PASSWORD, e.getMessage());
		}
		user.setPassword(password);
		
		if(errors.isEmpty()) {
			result = "Connexion succed";
		}
		else {
			result = "Connexion failed";
		}
		return user;
	}
	
	private void confirmPassword(String password) throws Exception {
		if(password != null) {
			throw new Exception("Please verify your password");
		}
	}
	
	private void confirmLogin(String login) throws Exception{
		if(login != null) {
			throw new Exception("Please enter a valide user name");
		}
	}
	
	private void setError(String champ, String message) {
		errors.put(champ, message);
	}
	
	private String getParameter(HttpServletRequest request, String parametre) {
		String valeur = request.getParameter(parametre);
		
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		}
		else {
			return valeur;
		}
	}
	
	public boolean isStatus1() {
		return false;
	}
	
	public boolean isStatus() {
		return false;
	}
	
	
	
	
	
	
	
}
