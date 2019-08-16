package cm.geolocalisation.tripcity.entities;

public class Departement {
	private String departement_nom;
	private String region_nom;
	
	public Departement() { }
	public Departement(String dep_nom, String region) {
		this.departement_nom = dep_nom;
		this.region_nom = region;
	}
	
	public void setDepartementNom(String dep_nom) {
		this.departement_nom = dep_nom;
	}
	public void setDepartementRegion(String region) {
		this.region_nom = region;
	}
	
	public String getDepartementNom() {
		return this.departement_nom;
	}
	public String getDepartementRegion() {
		return this.region_nom;
	}
}
