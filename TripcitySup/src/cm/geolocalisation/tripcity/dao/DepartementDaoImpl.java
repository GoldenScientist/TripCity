package cm.geolocalisation.tripcity.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;

import static cm.geolocalisation.tripcity.dao.DAOUtilitaire.*;
import cm.geolocalisation.tripcity.entities.Departement;
import cm.geolocalisation.tripcity.entities.Cite;

public class DepartementDaoImpl implements DepartementDao {
	private DAOFactory  daoFactory;
	// requêtes de selection
	private static final String SQL_SELECT_CITE_DEPARTEMENT_ET_REGION = "SELECT departement_nom, region_nom FROM Departement where departement_nom = ?";
	
	DepartementDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	private static Departement map(ResultSet resultSet) throws SQLException {
		Departement department = new Departement();	
		department.setDepartementNom(resultSet.getString("departement_nom"));
		department.setDepartementRegion(resultSet.getString("region_nom"));
		
		return department;
	}



	@Override
	public Departement trouver(Cite cite)throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    Departement department = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = (Connection) daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_CITE_DEPARTEMENT_ET_REGION, false, cite.getCiteDepartement());
	        resultSet = (ResultSet) preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if (resultSet.next()) {
	        	department = map(resultSet);
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	    	fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	    }
	    return department;
	}
}
