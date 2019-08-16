package cm.geolocalisation.tripcity.server;

import java.util.ArrayList;
import java.util.List;

import cm.geolocalisation.tripcity.entities.ArchitectureAppartement;

public class AppartmentContainer {
	
	private List<ArchitectureAppartement> listeDesAppartements;
	
	public AppartmentContainer() { 
		listeDesAppartements = new ArrayList<ArchitectureAppartement>( );
	}
	
	public List<ArchitectureAppartement> getAppartmentList() {
		return this.listeDesAppartements;
	}
	
	public void setAppartmentList(List<ArchitectureAppartement> listeDesAppartements) {
		this.listeDesAppartements = listeDesAppartements;
	}
}
