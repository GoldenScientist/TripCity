package cm.geolocalisation.tripcity.entities;

public class Reservation {
	private Long res_id;
	private Long id_cite;
	private Long us_id;
	private Long architectureChambres_id;
	private Long architectureAppartements_id;
	private Long architectureStudios_id;
	private String res_date;
	private String res_commentaire;

	public Reservation() { }
	public Reservation(Long id_cite, Long us_id, String res_date, Long architectureChambres, Long  architectureAppartements, Long architectureStudios,  String commentaire) {
		this.id_cite = id_cite;
		this.us_id = us_id;
		this.res_date = res_date;
		this.architectureChambres_id = architectureChambres;
		this.architectureAppartements_id = architectureAppartements;
		this.architectureStudios_id = architectureStudios;
		this.res_commentaire = commentaire;
	}
	
	public void setReservationId(Long id) {
		this.res_id = id;
	}
	public void setCiteId(Long id) {
		this.id_cite = id;
	}
	public void setUtilisateurId(Long id) {
		this.us_id = id;
	}
	public void setArchitectureChambresId(Long id) {
		this.architectureChambres_id = id;
	}
	public void setArchitectureAppartementsId(Long id) {
		this.architectureAppartements_id = id;
	}
	public void setArchitectureStudiosId(Long id) {
		this.architectureStudios_id = id;
	}
	public void setReservationDate(String date) {
		this.res_date = date;
	}
	public void setReservationCommentaire(String commentaire) {
		this.res_commentaire = commentaire;
	}
	
	
	public Long getReservationId() {
		return this.res_id;
	}
	public Long getReservationCiteId() {
		return this.id_cite;
	}
	public Long getArchitectureAppartementsId() {
		return this.architectureAppartements_id;
	}
	public Long getUtilisateurId() {
		return this.us_id;
	}
	public Long getArchitectureChambresId() {
		return this.architectureChambres_id;
	}
	public Long getArchitectureStudiosId() {
		return this.architectureStudios_id;
	}
	public String getReservationDate() {
		return this.res_date;
	}
	public String getReservationComentaire() {
		return this.res_commentaire;
	}
	
}
