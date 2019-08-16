package cm.geolocalisation.tripcity.server;

import java.util.List;

import org.restlet.resource.ClientResource;

import cm.geolocalisation.tripcity.entities.Cite;;

public class CiteResource {
	
	public final ClientResource cr = new ClientResource(EngineConfiguration.tripcity_path + "/rest/city");
	
	public CiteResource() {
		EngineConfiguration.getInstance();
	}
	
	public List<Cite> getAllCities(String district, String department) {
		final CiteResourceInterface pri = new ClientResource(EngineConfiguration.tripcity_path + "/rest/city/district/"+district+"/department/"+department).wrap(CiteResourceInterface.class);
		Container content = pri.getAllCitiesDistrictAndDepartment();
		return content.getCiteList();
	}
	
}

