package cm.geolocalisation.tripcity.server;

import org.restlet.resource.Get;

public interface CiteResourceInterface {
	
	@Get
	public Container getAllCitiesDistrictAndDepartment();
	
}
