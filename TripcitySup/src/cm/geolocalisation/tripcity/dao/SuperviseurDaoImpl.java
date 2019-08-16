package cm.geolocalisation.tripcity.dao;

import cm.geolocalisation.tripcity.entities.*;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

import static cm.geolocalisation.tripcity.dao.DAOUtilitaire.*;

public class SuperviseurDaoImpl implements SuperviseurDao {
	private DAOFactory  daoFactory;
	// requêtes de selection
	private static final String SQL_SELECT_SUPERVISEUR = "SELECT sup_id, sup_nom, sup_prenom, sup_email, sup_password, sup_dernierreVisite FROM Superviseur WHERE sup_email = ? AND sup_password = SHA1(?)";
	private static final String SQL_SELECT_SUPERVISEUR_ID = "SELECT sup_id, sup_nom, sup_prenom, sup_email, sup_password, sup_dernierreVisite FROM Superviseur WHERE sup_id = ?";
	
	SuperviseurDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	private static Superviseur map(ResultSet resultSet) throws SQLException {
		Superviseur user = new Superviseur();	
		user.setSuperviseurId(resultSet.getLong("sup_id"));
		user.setSuperviseurNom(resultSet.getString("sup_nom"));
		user.setSuperviseurPrenom(resultSet.getString("sup_prenom"));
		user.setSuperviseurEmail(resultSet.getString("sup_email"));
		user.setSuperviseurPassword(resultSet.getString("sup_password"));
		user.setSuperviseurDernierreVisite(resultSet.getString("sup_dernierreVisite"));
		
		return user;
	}

	@Override
	public Superviseur trouver(Superviseur superviseur) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Superviseur user = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = (Connection) daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_SUPERVISEUR, false, superviseur.getSuperviseurEmail(), superviseur.getSuperviseurPassword());
	        resultSet = (ResultSet) preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if (resultSet.next()) {
	        	user = map(resultSet);
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	    	fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	    }
	    
	    return user;
	}

	@Override
	public Superviseur trouver(Cite cite) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Superviseur user = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = (Connection) daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_SUPERVISEUR_ID, false, cite.getCiteSuperviseur());
	        resultSet = (ResultSet) preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if (resultSet.next()) {
	        	user = map(resultSet);
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	    	fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	    }
	    return user;
	}

}
