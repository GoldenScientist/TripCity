package cm.geolocalisation.tripcity.dao;

import cm.geolocalisation.tripcity.entities.*;

public interface SuperviseurDao {
	Superviseur  trouver(Superviseur superviseur) throws DAOException;
	Superviseur  trouver(Cite cite) throws DAOException;
}
