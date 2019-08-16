package cm.geolocalisation.tripcity.server;

import java.util.ArrayList;
import java.util.List;

import org.restlet.Request;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import cm.geolocalisation.tripcity.entities.Cite;
import cm.geolocalisation.tripcity.servlets.ListAllCitiesServlet;

public class CiteResource extends ServerResource implements CiteResourceInterface {
	
	Request request = Request.getCurrent();
	
	@Override
	@Get
	public Container getAllCitiesDistrictAndDepartment() {
		String param_district = request.getAttributes().get("district").toString();
		String param_department = request.getAttributes().get("department").toString();
		List<Cite> liste = new ArrayList<Cite>();
		Container content = new Container();
		List<Cite> listeDesCites = ListAllCitiesServlet.citeDao.lister(param_district, param_department);
		for (Cite ciy : listeDesCites) {
			liste.add(ciy);
        }
		content.setCiteList(liste);
		return content;
	}
}
