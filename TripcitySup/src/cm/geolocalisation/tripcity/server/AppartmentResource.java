package cm.geolocalisation.tripcity.server;

import java.util.ArrayList;
import java.util.List;

import org.restlet.Request;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import cm.geolocalisation.tripcity.entities.ArchitectureAppartement;
import cm.geolocalisation.tripcity.entities.Cite;
import cm.geolocalisation.tripcity.servlets.ListAllCitiesServlet;

public class AppartmentResource extends ServerResource implements AppartmentResourceInterface {
	
	Request request = Request.getCurrent();

	@Override
	@Get
	public AppartmentContainer getArchitectureAppartement() {
		String param_id = request.getAttributes().get("id_cite").toString();
		long id_cite = Long.parseLong(param_id);
		List<ArchitectureAppartement> liste = new ArrayList<ArchitectureAppartement>();
		AppartmentContainer content = new AppartmentContainer();
		List<ArchitectureAppartement> listeDesArcht = ListAllCitiesServlet.citeDao.trouver(id_cite);
		for (ArchitectureAppartement archt : listeDesArcht) {
			liste.add(archt);
        }
		content.setAppartmentList(liste);
		return content;
	}
}
