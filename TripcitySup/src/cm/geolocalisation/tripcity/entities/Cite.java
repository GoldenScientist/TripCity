package cm.geolocalisation.tripcity.entities;

public class Cite {
	private Long cite_id;
	private String cite_nom;
	private String cite_localisation;
	private String cite_contactConcierge;
	private String cite_avatar;
	private float cite_geoLatitude;
	private float cite_geoLongitude;
	private float cite_geoAltitude;
	private int cite_nbreAppartements;
	private int cite_nbreChambres;
	private int cite_nbreStudios;
	private String cite_dateInsertion;
	private String cite_description;
	private String quartier_nom;
	private String departement_nom;
	private Long superviseur_id;
	
	public Cite() { }
	public Cite(String nom, String localisation, String contactConcierge, String avatar, float latitude, float longitude,  float altitude, String description, String quartier, String departement, Long superviseur) {
		this.cite_nom = nom;
		this.cite_localisation = localisation;
		this.cite_contactConcierge = contactConcierge;
		this.cite_avatar = avatar;
		this.cite_geoLatitude = latitude;
		this.cite_geoLongitude = longitude;
		this.cite_geoAltitude = altitude;
		this.quartier_nom = quartier;
		this.cite_description = description;
		this.departement_nom = departement;
		this.superviseur_id = superviseur;
	}
	
	public void setCiteId(Long id) {
		this.cite_id = id;
	}
	public void setCiteNom(String nom) {
		this.cite_nom = nom;
	}
	public void setCiteLocalisation(String localisation) {
		this.cite_localisation = localisation;
	}
	public void setCiteContactConcierge(String contact) {
		this.cite_contactConcierge = contact;
	}
	public void setCiteAvatar(String avatar) {
		this.cite_avatar = avatar;
	}
	public void setCiteLatitude(float latitude) {
		this.cite_geoLatitude = latitude;
	}
	public void setCiteLongitude(float longitude) {
		this.cite_geoLongitude = longitude;
	}
	public void setCiteAltitude(float altitude) {
		this.cite_geoAltitude = altitude;
	}
	public void setCiteNbreChambres(int rating) {
		this.cite_nbreChambres = rating;
	}
	public void setCiteNbreAppartements(int visiteur) {
		this.cite_nbreAppartements = visiteur;
	}
	public void setCiteNbreStudios(int note) {
		this.cite_nbreStudios = note;
	}
	public void  setCiteDateInsertion(String date) {
		this.cite_dateInsertion = date;
	}
	public void setCiteDescription(String description) {
		this.cite_description = description;
	}
	public void setCiteQuartier(String quartier) {
		this.quartier_nom = quartier;
	}
	public void setCiteDepartement(String departement) {
		this.departement_nom = departement;
	}
	public void setCiteSuperviseur(Long utilisateur) {
		this.superviseur_id = utilisateur;
	}
	
	public Long getCiteId() {
		return this.cite_id;
	}
	public String getCiteNom() {
		return this.cite_nom;
	}
	public String getCiteLocalisation() {
		return this.cite_localisation;
	}
	public String getCiteContactConcierge() {
		return this.cite_contactConcierge;
	}
	public String getCiteAvatar() {
		return this.cite_avatar;
	}
	public float getCiteLatitude() {
		return this.cite_geoLatitude;
	}
	public float getCiteLongitude() {
		return this.cite_geoLongitude;
	}
	public float getCiteAltitude() {
		return this.cite_geoAltitude;
	}
	public int getCiteNbreChambres() {
		return this.cite_nbreChambres;
	}
	public int getCiteNbreAppartements() {
		return this.cite_nbreAppartements;
	}
	public int getCiteNbreStudios() {
		return this.cite_nbreStudios;
	}
	public String getCiteDateInsertion() {
		return this.cite_dateInsertion;
	}
	public String setCiteDescription() {
		return this.cite_description;
	}
	public String getCiteQuartier() {
		return this.quartier_nom;
	}
	public String getCiteDepartement() {
		return this.departement_nom;
	}
	
	public Long getCiteSuperviseur() {
		return superviseur_id;
	}
	
}
