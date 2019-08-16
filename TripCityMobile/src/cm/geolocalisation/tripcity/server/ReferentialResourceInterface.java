package cm.geolocalisation.tripcity.server;

import org.restlet.resource.Get;

public interface ReferentialResourceInterface {
	
	@Get
	public ReferentialsContainer getAllReferentials();
}
