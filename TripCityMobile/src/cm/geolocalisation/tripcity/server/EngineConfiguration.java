package cm.geolocalisation.tripcity.server;

import org.restlet.engine.Engine;
import org.restlet.ext.net.HttpClientHelper;
import org.restlet.ext.jackson.JacksonConverter;

public class EngineConfiguration {
	private static EngineConfiguration ourIstance = new EngineConfiguration();
	public final static String tripcity_path = "http://192.168.242.1:8080/TripcitySup";
	
	public static EngineConfiguration getInstance( ) {
		return ourIstance;
	}
	
	public EngineConfiguration() {
		Engine.getInstance().getRegisteredConverters().add(new JacksonConverter());
		Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null));
	}
	
	public static EngineConfiguration getOurIstance() {
		return ourIstance;
	}
	
	public static void setOurIstance(EngineConfiguration ourIstance) {
		EngineConfiguration.ourIstance = ourIstance;
	}
}
