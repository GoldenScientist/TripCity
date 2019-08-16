package cm.geolocalisation.tripcity.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static cm.geolocalisation.tripcity.dao.DAOUtilitaire.*;
import cm.geolocalisation.tripcity.entities.*;

public class CiteDaoImpl implements CiteDao {
	private DAOFactory  daoFactory;
	
	// requêtes de selection
	private static final String SQL_SELECT_REFERENTIEL = "SELECT re_id, re_nom, re_geoLatitude, re_geoLongitude, re_dateInsertion, quartier_nom, departement_nom, sup_id FROM Referentiel WHERE re_nom LIKE ?";
	private static final String SQL_SELECT_ARCHT_APPART = "SELECT architectureAppartements_id, id_cite, Appartement_lienPhoto, nbreChambres, nbreToilette, prix_Appartement, description_appartement FROM ArchitectureAppartements WHERE id_cite = ?";
	private static final String SQL_SELECT_ALL_CITIES = "SELECT "
			+ "id_cite, "
			+ "nom_cite, "
			+ "localisation_cite, "
			+ "description_cite, "
			+ "nbre_chambres, "
			+ "nbre_appartements, "
			+ "cite_geoLongitude, "
			+ "cite_geoLatitude, "
			+ "cite_geoAltitude, "
			+ "concierge_telephone, "
			+ "cite_lienPhoto, "
			+ "nbre_studios, "
			+ "insertionCite_date, "
			+ "quartier_nom, "
			+ "departement_nom, "
			+ "sup_id "
			+ "FROM Cite ORDER BY nom_cite ASC";
	private static final String SQL_SELECT_CITES_PARAM_QUARTIER_DEPARTEMENT = "SELECT id_cite, "
			+ "nom_cite, "
			+ "localisation_cite, "
			+ "description_cite, "
			+ "nbre_chambres, "
			+ "nbre_appartements, "
			+ "cite_geoLongitude, "
			+ "cite_geoLatitude, "
			+ "cite_geoAltitude, "
			+ "concierge_telephone, "
			+ "cite_lienPhoto, "
			+ "nbre_studios, "
			+ "quartier_nom, "
			+ "insertionCite_date, "
			+ "departement_nom, "
			+ "sup_id "
			+ "FROM Cite WHERE quartier_nom = ? AND departement_nom = ? ORDER BY nom_cite ASC";
	
	CiteDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	
	private static Cite map(ResultSet resultSet) throws SQLException {
		Cite city = new Cite();	
		city.setCiteId(resultSet.getLong("id_cite"));
		city.setCiteNom(resultSet.getString("nom_cite"));
		city.setCiteLocalisation(resultSet.getString("localisation_cite"));
		city.setCiteDescription(resultSet.getString("description_cite"));
		city.setCiteNbreChambres(resultSet.getInt("nbre_chambres"));
		city.setCiteNbreAppartements(resultSet.getInt("nbre_appartements"));
		city.setCiteLongitude(resultSet.getFloat("cite_geoLongitude"));
		city.setCiteLatitude(resultSet.getFloat("cite_geoLatitude"));
		city.setCiteAltitude(resultSet.getFloat("cite_geoAltitude"));
		city.setCiteContactConcierge(resultSet.getString("concierge_telephone"));
		city.setCiteAvatar(resultSet.getString("cite_lienPhoto"));
		city.setCiteNbreStudios(resultSet.getInt("nbre_studios"));
		city.setCiteDateInsertion(resultSet.getString("insertionCite_date"));
		city.setCiteQuartier(resultSet.getString("quartier_nom"));
		city.setCiteDepartement(resultSet.getString("departement_nom"));
		city.setCiteSuperviseur(resultSet.getLong("sup_id"));
		return city;
	}
	
	private static Referentiel mapReferentiel(ResultSet resultSet) throws SQLException {
		Referentiel referentiel = new Referentiel();	
		referentiel.setReferentielId(resultSet.getLong("re_id"));
		referentiel.setReferentielNom(resultSet.getString("re_nom"));
		referentiel.setReferentielLatitude(resultSet.getFloat("re_geoLatitude"));
		referentiel.setReferentielLongitude(resultSet.getFloat("re_geoLongitude"));
		referentiel.setReferentielDateInsertion(resultSet.getString("re_dateInsertion"));
		referentiel.setReferentielQuartier(resultSet.getString("quartier_nom"));
		referentiel.setReferentielDepartement(resultSet.getString("departement_nom"));
		referentiel.setReferentielUtilisateur(resultSet.getLong("sup_id"));
		return referentiel;
	}
	
	private static ArchitectureAppartement mapArchitectureAppartement(ResultSet resultSet) throws SQLException {
		ArchitectureAppartement archt = new ArchitectureAppartement();	
		archt.setArchitectureAppartementId(resultSet.getLong("architectureAppartements_id"));
		archt.setArchitectureAppartementIdCite(resultSet.getLong("id_cite"));
		archt.setArchitectureAppartementNbreChambres(resultSet.getInt("nbreChambres"));
		archt.setArchitectureAppartementNbreToillettes(resultSet.getInt("nbreToilette"));
		archt.setArchitectureAppartementPrix(resultSet.getString("prix_Appartement"));
		archt.setArchitectureAppartementPhoto(resultSet.getString("Appartement_lienPhoto"));
		archt.setArchitectureAppartementDescription(resultSet.getString("description_appartement"));
		return archt;
	}


	@Override
	public List<Cite> lister(String quartier, String departement) throws DAOException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Cite> city = new ArrayList<Cite>();
        try {
            connection = (Connection) daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_CITES_PARAM_QUARTIER_DEPARTEMENT, false, quartier, departement);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {
            	city.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return city;
	}

	
	@Override
	public List<Referentiel> listerReferentiels(String caractere) throws DAOException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Referentiel> referentiel = new ArrayList<Referentiel>();
        try {
            connection = (Connection) daoFactory.getConnection();
            System.out.println(caractere);
            preparedStatement = initialisationRequetePreparee(connection, SQL_SELECT_REFERENTIEL, false, "%"+caractere+"%");
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {
            	referentiel.add(mapReferentiel(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return referentiel;
	}


	@Override
	public List<Cite> lister() throws DAOException {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Cite> city = new ArrayList<Cite>();
        try {
            connection = (Connection) daoFactory.getConnection();
            preparedStatement = (PreparedStatement) connection.prepareStatement(SQL_SELECT_ALL_CITIES);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {
            	city.add(map(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connection);
        }
        return city;
	}


	@Override
	public List<ArchitectureAppartement> trouver(long id) throws DAOException {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<ArchitectureAppartement> archt = new ArrayList<ArchitectureAppartement>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = (Connection) daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_ARCHT_APPART, false, id);
	        resultSet = (ResultSet) preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	archt.add(mapArchitectureAppartement(resultSet));
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    } finally {
	    	fermeturesSilencieuses(resultSet, preparedStatement, connexion);
	    }
	    return archt;
	}
}
