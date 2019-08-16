package cm.geolocalisation.tripcity.entities;

public class Quartier {
	private String quartier_nom;
	private String departement_nom;
	
	public Quartier() { }
	public Quartier(String qu_nom, String departement_nom) {
		this.quartier_nom = qu_nom;
		this.departement_nom = departement_nom;
	}

	public void setQuartierNom(String qu_nom) {
		this.quartier_nom = qu_nom;
	}
	public void setQuartierDepartement(String departement_nom) {
		this.departement_nom = departement_nom;
	}
	
	public String getQuartierNom() {
		return this.quartier_nom;
	}
	public String getQuartierDepartement() {
		return this.departement_nom;
	}
}
