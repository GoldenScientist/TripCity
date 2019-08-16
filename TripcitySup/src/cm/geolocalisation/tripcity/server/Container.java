package cm.geolocalisation.tripcity.server;

import java.util.ArrayList;
import java.util.List;
import cm.geolocalisation.tripcity.entities.Cite;

public class Container {
	private List<Cite> listeDesCites;
	
	public Container() { 
		listeDesCites = new ArrayList<Cite>( );
	}
	
	public List<Cite> getCiteList() {
		return this.listeDesCites;
	}
	
	public void setCiteList(List<Cite> listeDesCites) {
		this.listeDesCites = listeDesCites;
	}
}
