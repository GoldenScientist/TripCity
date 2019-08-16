package cm.geolocalisation.tripcity.dao;

import cm.geolocalisation.tripcity.entities.*;

public interface DepartementDao {
	Departement  trouver(Cite cite) throws DAOException;
}
