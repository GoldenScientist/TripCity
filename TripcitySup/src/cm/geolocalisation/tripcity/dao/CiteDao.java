package cm.geolocalisation.tripcity.dao;

import cm.geolocalisation.tripcity.entities.*;

import java.util.List;

public interface CiteDao {
	/* 
	 * Cite
	 * */
	
	List<Cite> lister() throws DAOException;
	List<Cite> lister(String quartier, String departement) throws DAOException;
	
	/*
	 * Referentiel
	 * */
	List<Referentiel> listerReferentiels(String caractere) throws DAOException;
	
	/*
	 * Appartement
	 * */
	List<ArchitectureAppartement>  trouver(long id) throws DAOException;
}
