package cm.geolocalisation.tripcity.server;

import org.restlet.resource.Get;

public interface AppartmentResourceInterface {
	
	@Get
	public AppartmentContainer getArchitectureAppartement();
}
