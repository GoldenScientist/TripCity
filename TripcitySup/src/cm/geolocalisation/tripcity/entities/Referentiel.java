package cm.geolocalisation.tripcity.entities;

public class Referentiel {
	private Long re_id;
	private String re_nom;
	private float re_geoLatitude;
	private float re_geoLongitude;
	private String re_dateInsertion;
	private String quartier_nom;
	private String departement_nom;
	private Long utilisateur_id;
	
	public Referentiel() { }
	public Referentiel(String nom, float latitude, float longitude, String quartier, String departement, Long utilisateur) {
		this.re_nom = nom;
		this.re_geoLatitude = latitude;
		this.re_geoLongitude = longitude;
		this.quartier_nom = quartier;
		this.departement_nom = departement;
		this.utilisateur_id = utilisateur;
	}
	
	public void setReferentielId(Long id) {
		this.re_id = id;
	}
	public void setReferentielNom(String nom) {
		this.re_nom = nom;
	}
	public void setReferentielLatitude(float latitude) {
		this.re_geoLatitude = latitude;
	}
	public void setReferentielLongitude(float longitude) {
		this.re_geoLongitude = longitude;
	}
	
	public void  setReferentielDateInsertion(String date) {
		this.re_dateInsertion = date;
	}

	public void setReferentielQuartier(String quartier) {
		this.quartier_nom = quartier;
	}
	public void setReferentielDepartement(String departement) {
		this.departement_nom = departement;
	}
	public void setReferentielUtilisateur(Long utilisateur) {
		this.utilisateur_id = utilisateur;
	}
	
	public Long getReferentielId() {
		return this.re_id;
	}
	public String getReferentielNom() {
		return this.re_nom;
	}
	public float getReferentielLatitude() {
		return this.re_geoLatitude;
	}
	public float getReferentielLongitude() {
		return this.re_geoLongitude;
	}
	public String getReferentielDateInsertion() {
		return this.re_dateInsertion;
	}
	public String getReferentielQuartier() {
		return this.quartier_nom;
	}
	public String getReferentielDepartement() {
		return this.departement_nom;
	}
	public Long getReferentielUtilisateur() {
		return this.utilisateur_id;
	}
}
