package artere;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JacksonConfig extends ResourceConfig {
    public JacksonConfig() {
        packages("artere");
        register(JacksonFeature.class);
    }
}
