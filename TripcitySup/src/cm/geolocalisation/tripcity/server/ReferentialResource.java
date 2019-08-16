package cm.geolocalisation.tripcity.server;

import java.util.ArrayList;
import java.util.List;

import org.restlet.Request;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import cm.geolocalisation.tripcity.entities.Referentiel;
import cm.geolocalisation.tripcity.servlets.ListAllCitiesServlet;

public class ReferentialResource extends ServerResource implements ReferentialResourceInterface {
	
	Request request = Request.getCurrent();

	@Override
	@Get
	public ReferentialsContainer getAllReferentials() {
		String param_character = request.getAttributes().get("character").toString();
		List<Referentiel> liste = new ArrayList<Referentiel>();
		ReferentialsContainer content = new ReferentialsContainer();
		List<Referentiel> listeDesReferentiels = ListAllCitiesServlet.citeDao.listerReferentiels(param_character);
		for (Referentiel referential : listeDesReferentiels) {
			liste.add(referential);
        }
		content.setReferentielList(liste);
		return content;
	}

}
