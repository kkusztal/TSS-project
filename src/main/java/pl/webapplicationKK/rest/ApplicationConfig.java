package pl.webapplicationKK.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kasia
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(org.glassfish.jersey.jackson.JacksonFeature.class);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(pl.webapplicationKK.rest.WebserviceData.class);
    }
}
