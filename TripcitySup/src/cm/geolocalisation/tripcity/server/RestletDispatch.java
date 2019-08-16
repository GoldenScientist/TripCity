package cm.geolocalisation.tripcity.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class RestletDispatch extends Application {
	
	@Override
	public synchronized Restlet createInboundRoot() {
		Router router = new Router(getContext());
	
		router.attach("/city/district/{district}/department/{department}", CiteResource.class);
		router.attach("/city/referential/{character}", ReferentialResource.class);
		router.attach("/city/id_cite/{id_cite}", AppartmentResource.class);
		return router;
	}
}
