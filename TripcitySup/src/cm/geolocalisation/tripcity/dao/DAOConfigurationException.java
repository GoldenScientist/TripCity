package cm.geolocalisation.tripcity.dao;

@SuppressWarnings("serial")
public class DAOConfigurationException extends RuntimeException {
	public DAOConfigurationException(String message) {
		super(message);
	}
	public DAOConfigurationException(Throwable cause) {
		super(cause);
	}
	public DAOConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

}
