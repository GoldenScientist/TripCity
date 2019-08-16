package cm.geolocalisation.tripcity.forms;

import javax.servlet.http.HttpServletRequest;
import cm.geolocalisation.tripcity.entities.*;

import java.util.HashMap;
import java.util.Map;

public class ConnexionForm {
	private static final String CHAMP_EMAIL_UTILISATEUR = "superviseur_email";
	private static final String CHAMP_PASSWORD = "superviseur_password";
	
	private String result;
	private Map<String, String> errors = new HashMap<String, String>();
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public String getResult() {
		return result;
	}
	
	public Superviseur connectUser(HttpServletRequest request) {
		String email = getValueOf(request, CHAMP_EMAIL_UTILISATEUR);
		String password = getValueOf(request, CHAMP_PASSWORD);
		
		Superviseur user = new Superviseur();
		
		try {
			validationEmail(email);
		} catch(Exception e) {
			setErrors(CHAMP_EMAIL_UTILISATEUR, e.getMessage());
		}
		user.setSuperviseurEmail(email);
		
		try {
			validationPassword(password);
		} catch(Exception e) {
			setErrors(CHAMP_PASSWORD, e.getMessage());
		}
		user.setSuperviseurPassword(password);
		if(!errors.isEmpty()) {
			result = "Echec de la connexion";
		}
		
		return user;
	}
	
	private void validationEmail(String email) throws Exception {
		if(email != null && email.trim( ).length( ) != 0) {
			if(email.length() < 6) {
				throw new Exception("Nom d'utilisateur très court");
			} else if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}
	private void validationPassword(String password) throws Exception {
		if(password != null) {
			if(password.length() < 6) {
				throw new Exception("Mot de passe très court");
			}
		} else {
			throw new Exception("Merci de saisir un mot de passe valide");
		}
	}
	private void setErrors(String item, String message) {
		errors.put(item, message);
	}
	private static String getValueOf(HttpServletRequest request, String item) {
		String value = request.getParameter(item);
		if(value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value;
		}
	}
}