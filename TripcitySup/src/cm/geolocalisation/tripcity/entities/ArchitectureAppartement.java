package cm.geolocalisation.tripcity.entities;

public class ArchitectureAppartement {
	private Long id;
	private Long id_cite;
	private String photo;
	private int nbreChambres;
	private int nbreToillettes;
	private String prix;
	private String description;
	
	public ArchitectureAppartement() { }
	public ArchitectureAppartement(Long id_cite, String photo, int nbreChambres, int nbreToillettes, String prix, String description) {
		this.id_cite = id_cite;
		this.photo = photo;
		this.prix = prix;
		this.description  = description;
		this.nbreToillettes =  nbreToillettes;
		this.nbreChambres = nbreChambres;
	}
	
	public void setArchitectureAppartementId(Long id) {
		this.id = id;
	}
	public void setArchitectureAppartementIdCite(Long id) {
		this.id_cite = id;
	}
	public void setArchitectureAppartementPhoto(String p) {
		this.photo = p;
	}
	public void setArchitectureAppartementNbreToillettes(int k) {
		this.nbreToillettes = k;
	}
	public void setArchitectureAppartementNbreChambres(int k) {
		this.nbreChambres = k;
	}
	public void setArchitectureAppartementPrix(String p) {
		this.prix = p;
	}
	public void setArchitectureAppartementDescription(String p) {
		this.description = p;
	}
	
	public Long getArchitectureAppartementId() {
		return this.id;
	}
	public Long getArchitectureAppartementIdCite() {
		return this.id_cite;
	}
	
	public String getArchitectureAppartementPhoto() {
		return this.photo;
	}
	public String getArchitectureAppartementPrix() {
		return this.prix;
	}
	public int getArchitectureAppartementNbreChambres() {
		return this.nbreChambres;
	}
	public int getArchitectureAppartementNbreToilletes() {
		return this.nbreToillettes;
	}
	public String getArchitectureAppartementDescription() {
		return this.description;
	}
}
