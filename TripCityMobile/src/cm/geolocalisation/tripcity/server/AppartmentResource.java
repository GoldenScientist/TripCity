package cm.geolocalisation.tripcity.server;

import java.util.List;

import org.restlet.resource.ClientResource;

import cm.geolocalisation.tripcity.entities.ArchitectureAppartement;

public class AppartmentResource {
	
	public AppartmentResource() {
		EngineConfiguration.getInstance();
	}
	
	public ArchitectureAppartement getArchitectureAppartement(Long id) {
		final AppartmentResourceInterface ari = new ClientResource(EngineConfiguration.tripcity_path + "/rest/city/id_cite/"+id).wrap(AppartmentResourceInterface.class);
		AppartmentContainer contentAp = ari.getArchitectureAppartement();
		List<ArchitectureAppartement> too = contentAp.getAppartmentList();
		ArchitectureAppartement archt = too.get(0);
		return archt;
	}

}
