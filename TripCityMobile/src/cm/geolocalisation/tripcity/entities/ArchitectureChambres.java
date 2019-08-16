package cm.geolocalisation.tripcity.entities;

public class ArchitectureChambres {
	private Long id;
	private Long id_cite;
	private String photo;
	private String prix;
	private String description;
	
	public ArchitectureChambres() { }
	public ArchitectureChambres(Long id_cite, String photo, String prix, String description) {
		this.id_cite = id_cite;
		this.photo = photo;
		this.prix = prix;
		this.description  = description;
	}
	
	public void setArchitectureChambresId(Long id) {
		this.id = id;
	}
	public void setArchitectureChambresIdCite(Long id) {
		this.id_cite = id;
	}
	public void setArchitectureChambresPhoto(String p) {
		this.photo = p;
	}
	
	public void setArchitectureChambresPrix(String p) {
		this.prix = p;
	}
	public void setArchitectureAppartementDescription(String p) {
		this.description = p;
	}
	
	public Long getArchitectureChambrestId() {
		return this.id;
	}
	public Long getArchitectureChambresCite() {
		return this.id_cite;
	}
	
	public String getArchitectureChambresPhoto() {
		return this.photo;
	}
	public String getArchitectureChambresPrix() {
		return this.prix;
	}
	
	public String getArchitectureChambresDescription() {
		return this.description;
	}
}