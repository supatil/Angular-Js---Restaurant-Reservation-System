package egen.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class RestaurantConfig extends ResourceConfig {
	public RestaurantConfig(){
		packages("egen.jerseyimp");
	}

}
