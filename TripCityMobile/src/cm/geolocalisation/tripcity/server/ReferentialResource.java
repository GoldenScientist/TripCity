package cm.geolocalisation.tripcity.server;

import java.util.List;
import org.restlet.resource.ClientResource;
import cm.geolocalisation.tripcity.entities.Referentiel;

public class ReferentialResource {
	
	public ReferentialResource() {
		EngineConfiguration.getInstance();
	}
	
	public List<Referentiel> getAllReferentials(String caractere) {
		
		final ReferentialResourceInterface rri = new ClientResource(EngineConfiguration.tripcity_path + "/rest/city/referential/"+caractere).wrap(ReferentialResourceInterface.class);
		ReferentialsContainer content = rri.getAllReferentials();
		return content.getReferentielList();
	}

}
