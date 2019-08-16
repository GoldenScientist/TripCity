package cm.geolocalisation.tripcity.server;

import java.util.ArrayList;
import java.util.List;

import cm.geolocalisation.tripcity.entities.Referentiel;

public class ReferentialsContainer {
	
	private List<Referentiel> listeDesReferentiels;
	
	public ReferentialsContainer() { 
		listeDesReferentiels = new ArrayList<Referentiel>();
	}
	
	public List<Referentiel> getReferentielList() {
		return this.listeDesReferentiels;
	}
	
	public void setReferentielList(List<Referentiel> listeDesReferentiels) {
		this.listeDesReferentiels = listeDesReferentiels;
	}
}
