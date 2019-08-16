package cm.geolocalisation.tripcity.entities;

public class Superviseur {
	private Long id;
	private String utilisateur_nom;
	private String utilisateur_prenom;
	private String utilisateur_email;
	private String utilisateur_password;
	private String utilisateur_dernierreVisite;
	
	public Superviseur() { }
	public Superviseur(String nom, String email, String password) {
		this.utilisateur_nom = nom;
		this.utilisateur_email = email;
		this.utilisateur_password = password;
	}
	
	public void setSuperviseurId(Long id) {
		this.id = id;
	}
	public void setSuperviseurNom(String nom) {
		this.utilisateur_nom = nom;
	}
	public void setSuperviseurPrenom(String prenom) {
		this.utilisateur_prenom = prenom;
	}
	public void setSuperviseurEmail(String email) {
		this.utilisateur_email = email;
	}
	public void setSuperviseurPassword(String password) {
		this.utilisateur_password = password;
	}
	public void setSuperviseurDernierreVisite(String dernierre_visite) {
		this.utilisateur_dernierreVisite = dernierre_visite;
	}
	
	public Long getSuperviseurId() {
		return this.id;
	}
	public String getSuperviseurNom() {
		return this.utilisateur_nom;
	}
	public String getSuperviseurPrenom() {
		return this.utilisateur_prenom;
	}
	public String getSuperviseurEmail() {
		return this.utilisateur_email;
	}
	public String getSuperviseurPassword() {
		return this.utilisateur_password;
	}
	public String getSuperviseurDernierreVisite() {
		return this.utilisateur_dernierreVisite;
	}
}
