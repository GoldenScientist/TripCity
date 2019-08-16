package cm.geolocalisation.tripcity.entities;

public class Region {
	private String region_nom;
	
	public Region() { }
	public Region(String reg_nom) {
		this.region_nom = reg_nom;
	}
	
	public void setRegionNom(String reg_nom) {
		this.region_nom = reg_nom;
	}
	
	public String getRegionNom() {
		return this.region_nom;
	}
	
}
