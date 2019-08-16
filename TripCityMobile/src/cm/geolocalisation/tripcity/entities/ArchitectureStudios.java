package cm.geolocalisation.tripcity.entities;

public class ArchitectureStudios {
	
	private Long id;
	private Long id_cite;
	private String photo;
	private String prix;
	private String description;
	private boolean equipe;
 	
	public ArchitectureStudios() { }
	public ArchitectureStudios(Long id_cite, String photo, String prix, String description, boolean equipe) {
		this.id_cite = id_cite;
		this.photo = photo;
		this.prix = prix;
		this.equipe = equipe;
		this.description  = description;
	}
	
	public void setArchitectureStudiosId(Long id) {
		this.id = id;
	}
	public void setArchitectureStudiosIdCite(Long id) {
		this.id_cite = id;
	}
	public void setArchitectureStudiosPhoto(String p) {
		this.photo = p;
	}
	
	public void setArchitectureStudiosPrix(String p) {
		this.prix = p;
	}
	public void setArchitectureStudiosDescription(String p) {
		this.description = p;
	}
	public void setArchitectureStudiosEquipeId(boolean eq) {
		this.equipe = eq;
	}
	
	public Long getArchitectureStudiostId() {
		return this.id;
	}
	public Long getArchitectureStudiosCite() {
		return this.id_cite;
	}
	
	public String getArchitectureStudiosPhoto() {
		return this.photo;
	}
	public String getArchitectureStudiosPrix() {
		return this.prix;
	}
	
	public String getArchitectureStudiosDescription() {
		return this.description;
	}
	public boolean getArchitectureStudiosEquipe() {
		return this.equipe;
	}
}
