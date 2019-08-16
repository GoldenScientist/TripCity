package cm.geolocalisation.tripcity.entities;

public class Utilisateur {
	private Long id;
	private String utilisateur_nom;
	private String utilisateur_prenom;
	private String utilisateur_telephone;
	
	public Utilisateur() { }
	public Utilisateur(String nom, String email, String password) {
		this.utilisateur_nom = nom;
		this.utilisateur_telephone = password;
	}
	
	public void setUtilisateurId(Long id) {
		this.id = id;
	}
	public void setUtilisateurNom(String nom) {
		this.utilisateur_nom = nom;
	}
	public void setUtilisateurPrenom(String prenom) {
		this.utilisateur_prenom = prenom;
	}
	
	public void setUtilisateurTelephone(String password) {
		this.utilisateur_telephone = password;
	}

	
	public Long getUtilisateurId() {
		return this.id;
	}
	public String getUtilisateurNom() {
		return this.utilisateur_nom;
	}
	public String getUtilisateurPrenom() {
		return this.utilisateur_prenom;
	}
	
	public String getUtilisateurTelephone() {
		return this.utilisateur_telephone;
	}
}
