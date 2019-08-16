package cm.geolocalisation.tripcity.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {
	private static final String FICHIER_PROPERTIES = "/cm/geolocalisation/tripcity/dao/dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "utilisateur";
	private static final String PROPERTY_MOT_DE_PASSE = "password";
	
	private String url;
	private String username;
	private String password;
	
	DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	/*
	 * Méthode chargée de récuperer les informations de connexion à la base de données,
	 * charger le driver JDBC et retourner une instance de la Factory.
	 * */
	public static DAOFactory getInstance( ) throws DAOConfigurationException {
		Properties properties = new Properties( );
		String url;
		String driver;
		String utilisateur;
		String password;
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);
		if(fichierProperties == null) {
			throw new DAOConfigurationException("Le fichier properties"+ FICHIER_PROPERTIES + " est introuvable.");
		}
		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			utilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			password = properties.getProperty(PROPERTY_MOT_DE_PASSE);
		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier properties "+ FICHIER_PROPERTIES, e);
		}
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Le driver est introuvable dans le classpath. ", e);
		}
		
		DAOFactory instance = new DAOFactory(url, utilisateur, password);
		return instance;
	}
	/*
	 * Méthode chargée de fournir une connexion à la base de données.
	 * */
	Connection getConnection( ) throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	/*
	 * Méthodes de récuperation de l'implémentation des différents DAO.
	 * */
	public CiteDao getCiteDao() {
		return new CiteDaoImpl(this);
	}
	public DepartementDao getDepartementDao() {
		return new DepartementDaoImpl(this);
	}
	public SuperviseurDao getSuperviseurDao() {
		return new SuperviseurDaoImpl(this);
	}
}
